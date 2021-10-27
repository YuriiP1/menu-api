package com.example.menuapi.model.dto;

import com.example.menuapi.model.Location;
import com.example.menuapi.model.Menu;
import lombok.Data;

@Data
public class RestaurantRequest { ;

    private String name;
    private String imageUrl;
    private Location location;
    private Menu menu;
}
