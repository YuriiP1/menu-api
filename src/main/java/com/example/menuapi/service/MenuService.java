package com.example.menuapi.service;

import com.example.menuapi.model.Menu;
import com.example.menuapi.dto.MenuRestaurantRequest;

public interface MenuService {
    Menu createAndStoreMenu();

    Menu saveMenu(MenuRestaurantRequest request);
}
