package com.example.menuapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuRestaurantRequest {
    private String nameRestaurant;
    private String latitude;
    private String longitude;
    private List<MenuCategoryRequest> menuCategory;
}
