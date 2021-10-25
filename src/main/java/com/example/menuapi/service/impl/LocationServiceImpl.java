package com.example.menuapi.service.impl;

import com.example.menuapi.exception.entity.ValidationException;
import com.example.menuapi.model.Location;
import com.example.menuapi.repo.LocationRepository;
import com.example.menuapi.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Optional<Location> getById(Location location) {
        return inquireById(location);
    }

    @Override
    public Location getByLongitudeAndLatitude(Location location) {
        validateLocation(location);
        return inquireByLongitudeAndLatitude(location);
    }

    private Location inquireByLongitudeAndLatitude(Location location) {
        return locationRepository.findByLatitudeAndLongitude(location.getLatitude(), location.getLongitude());
    }

    private Optional<Location> inquireById(Location location) {
        validateLocation(location);
        return locationRepository.findById(location.getId());
    }

    @Override
    public Location createAndStoreLocation(Location location) {
        validateLocation(location);
        return updateOrCreateOne(location);
    }

    private Location updateOrCreateOne(Location location) {
        Location storedLocation = inquireByLongitudeAndLatitude(location);
        if (Objects.isNull(storedLocation))
            return locationRepository.save(location);
        else
            return storedLocation;
    }

    private void validateLocation(Location location) {
        if (Objects.isNull(location))
            throw new ValidationException("Location cannot be null");
        if (Objects.isNull(location.getLatitude()) || Objects.isNull(location.getLongitude()))
            throw new ValidationException("One of two fields are null: latitude - " + location.getLatitude() + ", longitude - " + location.getLongitude());
    }
}
