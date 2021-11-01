package com.example.menuapi.service.impl;

import com.example.menuapi.model.Menu;
import com.example.menuapi.model.dto.MenuCategoryRequest;
import com.example.menuapi.repo.MenuCategoryRepository;
import com.example.menuapi.service.MenuCategoryService;
import com.example.menuapi.service.MenuItemService;
import org.springframework.stereotype.Service;

@Service
public class MenuCategoryServiceImpl implements MenuCategoryService {

    private final MenuCategoryRepository menuCategoryRepository;
    private final MenuItemService menuItemService;

    public MenuCategoryServiceImpl(MenuCategoryRepository menuCategoryRepository, MenuItemService menuItemService) {
        this.menuCategoryRepository = menuCategoryRepository;
        this.menuItemService = menuItemService;
    }

    @Override
    public void saveMenuCategory(MenuCategoryRequest menuCategory, Menu menu) {

    }
}
