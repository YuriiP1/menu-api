package com.example.menuapi.service;

import com.example.menuapi.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAll();

    Restaurant getById(Long id);

    Restaurant getByName(String name);

    Restaurant inquireBySelectedParameter(Long id, String name);
}
