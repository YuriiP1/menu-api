package com.example.menuapi.dto;

import com.example.menuapi.model.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class MenuCategoryRequest {
    private String name;
    private List<MenuItemRequest> menuItem;
    @JsonIgnore
    private Menu menu;
}
