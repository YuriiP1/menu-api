package com.example.menuapi.dto;

import com.example.menuapi.model.Location;
import com.example.menuapi.model.Menu;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestaurantRequest {
    private String name;
    private String imageUrl;
    private Location location;
    private Menu menu;
    private String latitude;
    private String longitude;
}
