package com.anirudh.cab_service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anirudh.cab_service.Model.Driver;

public interface DriverRepo extends JpaRepository<Driver, String> {

    
} 
