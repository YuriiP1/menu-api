package com.example.menuapi.model.dto;

import com.example.menuapi.model.Location;
import com.example.menuapi.model.Menu;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class RestaurantRequest { ;

    @NotNull(message = "Name shouldn't be null")
    @NotBlank(message = "Name should have at least 1 symbol")
    private String name;

    @NotNull(message = "Image should be not null")
    private String imageUrl;

    @NotNull(message = "Location is required")
    private Location location;

//    @NotNull(message = "Menu is required")
    private Menu menu;
}
