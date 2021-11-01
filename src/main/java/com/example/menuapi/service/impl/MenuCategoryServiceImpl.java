package com.example.menuapi.service.impl;

import com.example.menuapi.mapper.MenuCategoryMapper;
import com.example.menuapi.model.Menu;
import com.example.menuapi.model.MenuCategory;
import com.example.menuapi.model.dto.MenuCategoryRequest;
import com.example.menuapi.model.dto.MenuItemRequest;
import com.example.menuapi.repo.MenuCategoryRepository;
import com.example.menuapi.service.MenuCategoryService;
import com.example.menuapi.service.MenuItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuCategoryServiceImpl implements MenuCategoryService {

    private final MenuCategoryRepository menuCategoryRepository;
    private final MenuItemService menuItemService;
    private final MenuCategoryMapper mapper;

    public MenuCategoryServiceImpl(MenuCategoryRepository menuCategoryRepository, MenuItemService menuItemService, MenuCategoryMapper mapper) {
        this.menuCategoryRepository = menuCategoryRepository;
        this.menuItemService = menuItemService;
        this.mapper = mapper;
    }

    @Override
    public void saveMenuCategory(MenuCategoryRequest request, Menu menu) {
        request.setMenu(menu);
        MenuCategory menuCategory = mapper.convertRequestToEntity(request);
        MenuCategory savedMenuCategory = menuCategoryRepository.save(menuCategory);
        request.getMenuItem()
                .forEach(menuItem -> menuItem.setMenuCategory(savedMenuCategory));
        menuItemService.saveMenuItems(request.getMenuItem());
    }
}
