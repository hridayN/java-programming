package com.socialapi.controller;

import com.socialapi.models.Location;
import com.socialapi.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {
    @Autowired
    private ILocationService locationService;

    @RequestMapping(value = "/locations")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @RequestMapping(value = "/location/{id}")
    public Location getLocationById(@PathVariable String id) {
        return locationService.getLocationById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/locations")
    public void addLocation(@RequestBody Location location) {   // @RequestBody annotation tells spring that this is a request body param
        locationService.addLocation(location);
    }
}
