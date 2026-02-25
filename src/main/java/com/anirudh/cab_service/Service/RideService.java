package com.anirudh.cab_service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anirudh.cab_service.Model.Driver;
import com.anirudh.cab_service.Model.RideDetails;
import com.anirudh.cab_service.Model.dto.Location;
import com.anirudh.cab_service.Model.dto.PassengerRideRequest;
import com.anirudh.cab_service.Model.dto.RiderDriverConnection;
import com.anirudh.cab_service.Repo.DriverRepo;
import com.anirudh.cab_service.Repo.RideDetailsRepo;

@Service
public class RideService {
    
    @Autowired
    private FareService fareService;
    @Autowired
    private NotificationService notificationService;

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private RideDetailsRepo rideDetailsRepo;
    
    public List<Driver> searchDriver(Location source) {
        List<Driver> drivers = new ArrayList<>();
        // Implement nearest drivers who are available
        for (Driver driver: driverRepo.findAll()) {
            if (driver.isAvailability()) {
                drivers.add(driver);
            }
        }
        
        return drivers;
    }
    
    public String requestRide(PassengerRideRequest passengerRideRequest){

        Location source = passengerRideRequest.source();
        Location destination = passengerRideRequest.destination();
        System.out.println(source + " " + destination);

        double fare = fareService.getFare(source, destination);
        System.out.println("fare is; " + fare);

        List<Driver> nearestDrivers = searchDriver(source);
        
        String ack = notificationService.notifyDrivers(nearestDrivers, passengerRideRequest, fare); //or send to driver controller
        
        return ack;
    }

    public void connectWithRider(RiderDriverConnection driverResponse) {
        //change repo to ride ongoing
        String rideId = "RID"+ UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        RideDetails details = RideDetails.builder()
                    .id(rideId)
                    .riderId(driverResponse.request().riderId())
                    .DriverId(driverResponse.driverId())
                    .status(driverResponse.accept())
                    .build();
        rideDetailsRepo.save(details);

        //notify or change page to driver/rider

    }
    
    // public void assignDriver(String userId) {
    //     //change in rideDetails repo
    //     //change passenger availablity to false
    //     notificationService.notifyPassenger(userId); // what about fare 
    // }
    
    
    
}








