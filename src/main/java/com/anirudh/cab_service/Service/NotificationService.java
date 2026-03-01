package com.anirudh.cab_service.Service;

import java.util.List;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.anirudh.cab_service.Model.Driver;
import com.anirudh.cab_service.Model.dto.PassengerRideRequest;
import com.anirudh.cab_service.Model.dto.RideNotificationPayload;
import com.anirudh.cab_service.Model.dto.RiderDriverConnection;

@Service
public class NotificationService {

    private final SimpMessagingTemplate messagingTemplate;

    public NotificationService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public String notifyDrivers(List<Driver> drivers, PassengerRideRequest request, double fare) {
        RideNotificationPayload payload = new RideNotificationPayload(
                request.riderId(),
                request.riderName(),
                request.source(),
                request.destination(),
                fare
        );

        for (Driver driver : drivers) {
            String destination = "/topic/update/driver/" + driver.getDriverId();
            messagingTemplate.convertAndSend(destination, payload);
        }

        return "Broadcasted to nearest Drivers.";
    }

    public void notifyPassenger(String userId) {
        // implement later
    }

    public void connectDriverRider(RiderDriverConnection driverResponse) {
        // Push to User1 (Driver) — show passenger details page
        messagingTemplate.convertAndSend(
            "/topic/ride/" + driverResponse.driverId(),
            driverResponse.request()
        );

        // Push to User2 (Passenger) — update their page
        messagingTemplate.convertAndSend(
            "/topic/ride/" + driverResponse.request().riderId(),
            "Your ride was accepted! your Driver is on the way!!"
        );
    }

    public void endRide(RiderDriverConnection ride) {
        // Notify Driver
        messagingTemplate.convertAndSend(
                "/topic/ride/" + ride.driverId(),
                "RIDE_COMPLETED"
        );

        // Notify Passenger
        messagingTemplate.convertAndSend(
                "/topic/ride/" + ride.request().riderId(),
                "RIDE_COMPLETED"
        );
    }
}
