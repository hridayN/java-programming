package com.socialapi.service;

import com.socialapi.models.Location;

import java.util.List;

public interface ILocationService {
    List<Location> getAllLocations();

    Location getLocationById(String id);

    void addLocation(Location location);
}
