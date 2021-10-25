package com.example.menuapi.service.impl;

import com.example.menuapi.exception.entity.ValidationException;
import com.example.menuapi.model.Location;
import com.example.menuapi.repo.LocationRepository;
import com.example.menuapi.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location getById(Location location) {
        return inquireById(location);
    }

    private Location inquireById(Location location) {
        validateLocation(location);
        return locationRepository.findById(location);
    }

    @Override
    public Location createAndStoreLocation(Location location) {
        validateLocation(location);
        return updateOrCreateOne(location);
    }

    private Location updateOrCreateOne(Location location) {
        Location locationById = this.getById(location);
        if (Objects.isNull(locationById))
            return locationRepository.save(location);
        else
            return locationById;
    }

    private void validateLocation(Location location) {
        if (Objects.isNull(location))
            throw new ValidationException("Location cannot be null");
        if (Objects.isNull(location.getLatitude()) || Objects.isNull(location.getLongitude()))
            throw new ValidationException("One of two fields are null: latitude - " + location.getLatitude() + ", longitude - " + location.getLongitude());
    }
}
