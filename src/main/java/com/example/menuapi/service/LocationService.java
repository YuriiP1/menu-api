package com.example.menuapi.service;

import com.example.menuapi.model.Location;

import java.util.Optional;

public interface LocationService {
    Optional<Location> getById(Location location);

    Location getByLongitudeAndLatitude(Location location);

    Location createAndStoreLocation(Location location);
}
