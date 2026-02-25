package com.anirudh.cab_service.Service;

import org.springframework.stereotype.Service;

import com.anirudh.cab_service.Model.dto.Location;


@Service
public class FareService {  
    
    public double getFare(Location source, Location destination) {
        double sx = source.x();
        double sy = source.y();
        
        double dx = destination.x();
        double dy = destination.y();
        
        
        double farePerKM = 10;
        
        double distance = Math.sqrt(Math.pow((dx - sx), 2)+ Math.pow((dy - sy), 2));
        
        double fare = distance * farePerKM;
        
        return fare;
    }
}