package com.example.menuapi.service.impl;

import com.example.menuapi.exception.entity.ValidationException;
import com.example.menuapi.mapper.RestaurantMapper;
import com.example.menuapi.model.Location;
import com.example.menuapi.model.Menu;
import com.example.menuapi.model.Restaurant;
import com.example.menuapi.model.dto.RestaurantRequest;
import com.example.menuapi.model.dto.RestaurantResponse;
import com.example.menuapi.repo.RestaurantRepository;
import com.example.menuapi.service.LocationService;
import com.example.menuapi.service.MenuService;
import com.example.menuapi.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    private final LocationService locationService;
    private final MenuService menuService;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper, LocationService locationService, MenuService menuService) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
        this.locationService = locationService;
        this.menuService = menuService;
    }

    @Override
    public List<Restaurant> getAll(Boolean isMainPage) {
        return isMainPage ? inquireRestaurantsNameAndLocation() : inquireAll();
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
        Menu menu = menuService.createAndStoreMenu(request.getMenu());
        request.setLocation(location);
        request.setMenu(menu);
        Restaurant restaurant = restaurantMapper.convertRequestToEntity(request);
        return restaurantRepository.save(restaurant);
    }

    private Restaurant inquireByIdAndName(Long id, String name) {
        return restaurantRepository.findByIdAndName(id, name)
                .orElseThrow(
                        () -> new ValidationException("Nothing found by this parameters: " + id + ", " + name)
                );
    }

    private List<Restaurant> inquireRestaurantsNameAndLocation() {
        List<RestaurantResponse> response = restaurantRepository.findAllNameAndLocation();
        List<Restaurant> restaurants = restaurantMapper.convertResponseToEntity(response);
        return validateListOfRestaurant(restaurants);
    }

    private List<Restaurant> inquireAll() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return validateListOfRestaurant(restaurants);
    }

    private List<Restaurant> validateListOfRestaurant(List<Restaurant> restaurants) {
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
