package com.example.menuapi.service;

import com.example.menuapi.model.Location;

public interface LocationService {
    Location getById(Location location);

    Location createAndStoreLocation(Location location);
}
