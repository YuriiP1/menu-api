package com.example.menuapi.service;

import com.example.menuapi.model.Menu;
import com.example.menuapi.dto.MenuCategoryRequest;

public interface MenuCategoryService {
    void saveMenuCategory(MenuCategoryRequest menuCategory, Menu menu);
}
