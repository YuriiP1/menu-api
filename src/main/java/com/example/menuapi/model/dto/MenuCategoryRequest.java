package com.example.menuapi.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuCategoryRequest {
    private String name;
    private List<MenuItemRequest> menuItem;
}
