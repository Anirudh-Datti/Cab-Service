package com.anirudh.cab_service.Model.dto;


public record PassengerRideRequest(
    String riderId,
    String riderName,
    Location source,
    Location destination
) {
    
}
