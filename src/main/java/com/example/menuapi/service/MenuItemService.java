package com.example.menuapi.service;

import com.example.menuapi.model.dto.MenuItemRequest;

import java.util.List;

public interface MenuItemService {
    void saveMenuItems(List<MenuItemRequest> menuItem);
}
