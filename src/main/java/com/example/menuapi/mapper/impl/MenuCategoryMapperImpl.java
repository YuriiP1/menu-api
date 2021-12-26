package com.example.menuapi.mapper.impl;

import com.example.menuapi.mapper.MenuCategoryMapper;
import com.example.menuapi.model.MenuCategory;
import com.example.menuapi.dto.MenuCategoryRequest;
import org.springframework.stereotype.Component;

@Component
public class MenuCategoryMapperImpl implements MenuCategoryMapper {
    @Override
    public MenuCategory convertRequestToEntity(MenuCategoryRequest request) {
        MenuCategory response = new MenuCategory();
        response.setName(request.getName());
        response.setMenu(request.getMenu());
        return response;
    }
}
