package com.anirudh.cab_service.Model.dto;

public record RiderDriverConnection(
    String driverId,
    boolean accept,
    PassengerRideRequest request, 
    String rideStatus
) {
    
}
