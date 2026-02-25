package com.anirudh.cab_service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;   
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor 
@Data 
@Entity 
public class Driver {   
    @Id
    private String driverId;
    private String driverName;
    private boolean availability;
    private double latitude;
    private double longitude;
    
}
