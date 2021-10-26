package com.example.menuapi.service.impl;

import com.example.menuapi.exception.entity.ValidationException;
import com.example.menuapi.mapper.RestaurantMapper;
import com.example.menuapi.model.Location;
import com.example.menuapi.model.Restaurant;
import com.example.menuapi.model.dto.RestaurantRequest;
import com.example.menuapi.repo.RestaurantRepository;
import com.example.menuapi.service.LocationService;
import com.example.menuapi.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    private final LocationService locationService;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper, LocationService locationService) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
        this.locationService = locationService;
    }

    @Override
    public List<Restaurant> getAll() {
        return inquireAll(restaurantRepository.findAll());
    }

    @Override
    public Restaurant getById(Long id) {
        return inquireById(id);
    }

    @Override
    public Restaurant getByName(String name) {
        return inquireByName(name);
    }

    @Override
    public Restaurant inquireBySelectedParameter(Long id, String name) {
        if (Objects.nonNull(name))
            if (Objects.nonNull(id))
                return this.inquireByIdAndName(id, name);
            else
                return this.getByName(name);
        else
            return this.getById(id);
    }

    @Override
    public Restaurant createAndStoreRestaurant(RestaurantRequest request) {
        Location location = locationService.createAndStoreLocation(request.getLocation());
        request.setLocation(location);
        Restaurant restaurant = restaurantMapper.convertDtoToEntity(request);
        return restaurantRepository.save(restaurant);
    }

    private Restaurant inquireByIdAndName(Long id, String name) {
        return restaurantRepository.findByIdAndName(id, name)
                .orElseThrow(
                        () -> new ValidationException("Nothing found by this parameters: " + id + ", " + name)
                );
    }

    private List<Restaurant> inquireAll(List<Restaurant> restaurants) {
        if (restaurants.isEmpty())
            throw new ValidationException("There is no restaurants!!!");
        return restaurants;
    }

    private Restaurant inquireById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(
                        () -> new ValidationException("Nothing found by id: " + id)
                );
    }

    private Restaurant inquireByName(String name) {
        return restaurantRepository.findByName(name)
                .orElseThrow(
                        () -> new ValidationException("Nothing found by name: " + name)
                );
    }
}
