package com.example.menuapi.mapper.impl;

import com.example.menuapi.mapper.MenuItemMapper;
import com.example.menuapi.model.MenuItem;
import com.example.menuapi.dto.MenuItemRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemMapperImpl implements MenuItemMapper {
    @Override
    public List<MenuItem> convertRequestToEntity(List<MenuItemRequest> request) {
        List<MenuItem> menuItems = new ArrayList<>();
        request.forEach(
                menuItemRequest -> {
                    MenuItem response = new MenuItem();
                    response.setName(menuItemRequest.getName());
                    response.setDescription(menuItemRequest.getDescription());
                    response.setMenuCategory(menuItemRequest.getMenuCategory());
                    menuItems.add(response);
                }
        );
        return menuItems;
    }
}
