package com.example.menuapi.service.impl;

import com.example.menuapi.model.Menu;
import com.example.menuapi.repo.MenuRepository;
import com.example.menuapi.service.MenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu createAndStoreMenu() {
        Menu menu = new Menu();
        return menuRepository.save(menu);
    }
}
