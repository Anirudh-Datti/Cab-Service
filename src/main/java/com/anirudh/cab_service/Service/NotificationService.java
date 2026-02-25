package com.anirudh.cab_service.Service;

import java.util.List;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.anirudh.cab_service.Model.Driver;
import com.anirudh.cab_service.Model.dto.PassengerRideRequest;
import com.anirudh.cab_service.Model.dto.RideNotificationPayload;

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
}
