package com.example.menuapi.mapper;

import com.example.menuapi.model.Restaurant;
import com.example.menuapi.model.dto.RestaurantRequest;
import org.mapstruct.Mapper;

@Mapper
public interface RestaurantMapper {

    Restaurant convertDtoToEntity(RestaurantRequest request);
}
