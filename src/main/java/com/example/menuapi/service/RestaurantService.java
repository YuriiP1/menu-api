package com.example.menuapi.service;

import com.example.menuapi.model.Restaurant;
import com.example.menuapi.dto.RestaurantRequest;
import com.example.menuapi.dto.RestaurantResponse;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAll(Boolean isMainPage);

    Restaurant getById(Long id);

    Restaurant getByName(String name);

    Restaurant inquireBySelectedParameter(Long id, String name);

    RestaurantResponse createAndStoreRestaurant(RestaurantRequest restaurant);

    Restaurant findByNameAndLocation(RestaurantRequest restaurantRequest);
}
