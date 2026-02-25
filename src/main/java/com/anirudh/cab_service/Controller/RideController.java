package com.anirudh.cab_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anirudh.cab_service.Model.dto.PassengerRideRequest;
import com.anirudh.cab_service.Service.RideService;


@RestController
@RequestMapping("/ride")
public class RideController {
    
    @Autowired
    private RideService rideService;
    
    
    @PostMapping("/request")
    public String requestRide(@RequestBody PassengerRideRequest passengerRideRequest) {
        rideService.requestRide(passengerRideRequest);
        return "ride request success";
    }
}