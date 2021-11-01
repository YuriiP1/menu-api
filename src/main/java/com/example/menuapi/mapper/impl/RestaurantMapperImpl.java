package com.example.menuapi.mapper.impl;

import com.example.menuapi.mapper.RestaurantMapper;
import com.example.menuapi.model.Restaurant;
import com.example.menuapi.model.dto.RestaurantRequest;
import com.example.menuapi.model.dto.RestaurantResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class RestaurantMapperImpl implements RestaurantMapper {

    @Override
    public Restaurant convertRequestToEntity(RestaurantRequest request) {
        if (Objects.isNull(request))
            return null;
        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getName());
        restaurant.setImageUrl(request.getImageUrl());
        restaurant.setLocation(request.getLocation());
        restaurant.setMenu(request.getMenu());
        return restaurant;
    }

    @Override
    public List<Restaurant> convertResponseToEntity(List<RestaurantResponse> response) {
        List<Restaurant> restaurants = new ArrayList<>();
        response.forEach(restaurantResponse -> {
            Restaurant restaurant = new Restaurant();
            restaurant.setName(restaurantResponse.getName());
            restaurant.setLocation(restaurantResponse.getLocation());
            restaurants.add(restaurant);
        });
        return restaurants;
    }

    @Override
    public RestaurantResponse convertEntityToResponse(Restaurant restaurant) {
        RestaurantResponse response = new RestaurantResponse();
        response.setName(restaurant.getName());
        response.setLocation(restaurant.getLocation());
        return  response;
    }
}
