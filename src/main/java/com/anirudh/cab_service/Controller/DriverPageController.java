package com.anirudh.cab_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anirudh.cab_service.Model.dto.RiderDriverConnection;
import com.anirudh.cab_service.Service.RideService;

@Controller
public class DriverPageController {

    @Autowired
    private RideService rideService;

    @GetMapping("/update/driver/{id}")
    public String driverPage(@PathVariable String id, Model model) {
        model.addAttribute("driverId", id);
        return "driver";
    }

    @PostMapping("")
    public String accept(@RequestBody RiderDriverConnection driverResponse) {
        if (driverResponse.accept())
            rideService.connectWithRider(driverResponse);
    }
}
