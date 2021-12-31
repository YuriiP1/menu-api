package com.example.menuapi.dto;

import com.example.menuapi.model.Location;
import com.example.menuapi.model.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imageUrl;
    private Location location;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Menu menu;

    public RestaurantResponse(String name, Location location) {
        this.name = name;
        this.location = location;
    }
}
