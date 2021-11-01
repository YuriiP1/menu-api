package com.example.menuapi.service.impl;

import com.example.menuapi.repo.MenuItemRepository;
import com.example.menuapi.service.MenuItemService;
import org.springframework.stereotype.Service;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }
}
