package com.anirudh.cab_service.Model.dto;


public record RideNotificationPayload(
    String riderId,
    String riderName,
    Location source,
    Location destination,
    double fare
) {

}
