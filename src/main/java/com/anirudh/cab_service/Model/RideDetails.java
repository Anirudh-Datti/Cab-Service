package com.anirudh.cab_service.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class RideDetails {

    @Id
    private String id;
    private String riderId;
    private String DriverId;
    private String status; //enum? ongoing, completed?


}
