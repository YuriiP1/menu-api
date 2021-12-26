package com.example.menuapi.mapper;

import com.example.menuapi.model.Restaurant;
import com.example.menuapi.dto.RestaurantRequest;
import com.example.menuapi.dto.RestaurantResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RestaurantMapper {

    Restaurant convertRequestToEntity(RestaurantRequest request);

    List<Restaurant> convertResponseToEntity(List<RestaurantResponse> response);

    RestaurantResponse convertEntityToResponse(Restaurant restaurant);
}
