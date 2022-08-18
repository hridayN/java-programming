package com.socialapi.service;

import com.socialapi.models.Location;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service	// annotation to indicate this class is an business service containing the business logic
public class LocationService implements ILocationService {
    Location location1 = new Location("l1", "Lagos");
    Location location2 = new Location("l2", "Asaba");
    Location location3 = new Location("l3", "Budapest");

    private List<Location> locations = new ArrayList<>(Arrays.asList(location1, location2, location3));
    @Override
    public List<Location> getAllLocations()
    {
        return locations;
    }

    @Override
    public Location getLocationById(String id) {
        return locations.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addLocation(Location location) {
        locations.add(location);
    }
}
