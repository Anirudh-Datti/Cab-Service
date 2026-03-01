package com.anirudh.cab_service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anirudh.cab_service.Model.RideDetails;

public interface RideDetailsRepo extends JpaRepository<RideDetails, String>{

    
} 