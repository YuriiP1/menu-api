package com.example.menuapi.dto;

import com.example.menuapi.model.MenuCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class MenuItemRequest {
    private String name;
    private String description;
    private Double price;
    @JsonIgnore
    private MenuCategory menuCategory;
}
