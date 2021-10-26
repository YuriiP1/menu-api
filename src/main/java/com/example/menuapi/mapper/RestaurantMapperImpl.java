package com.example.menuapi.mapper;

import com.example.menuapi.model.Restaurant;
import com.example.menuapi.model.dto.RestaurantRequest;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RestaurantMapperImpl implements RestaurantMapper{

    @Override
    public Restaurant convertDtoToEntity(RestaurantRequest request) {
        if (Objects.isNull(request))
            return null;
        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getName());
        restaurant.setImageUrl(request.getImageUrl());
        restaurant.setLocation(request.getLocation());
        restaurant.setMenu(request.getMenu());
        return restaurant;
    }
}
