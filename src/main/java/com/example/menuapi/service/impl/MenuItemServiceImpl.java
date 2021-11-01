package com.example.menuapi.service.impl;

import com.example.menuapi.mapper.MenuItemMapper;
import com.example.menuapi.model.MenuItem;
import com.example.menuapi.model.dto.MenuItemRequest;
import com.example.menuapi.repo.MenuItemRepository;
import com.example.menuapi.service.MenuItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final MenuItemMapper menuItemMapper;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository, MenuItemMapper menuItemMapper) {
        this.menuItemRepository = menuItemRepository;
        this.menuItemMapper = menuItemMapper;
    }

    @Override
    public void saveMenuItems(List<MenuItemRequest> menuItem) {
        List<MenuItem> convertedMenuItems = menuItemMapper.convertRequestToEntity(menuItem);
        menuItemRepository.saveAll(convertedMenuItems);
    }
}
