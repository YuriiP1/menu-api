package com.example.menuapi.service;

import com.example.menuapi.model.Menu;
import com.example.menuapi.model.dto.MenuCategoryRequest;

import java.util.List;

public interface MenuCategoryService {
    void saveMenuCategory(MenuCategoryRequest menuCategory, Menu menu);
}
