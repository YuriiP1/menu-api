package com.example.menuapi.service.impl;

import com.example.menuapi.model.Menu;
import com.example.menuapi.model.Restaurant;
import com.example.menuapi.model.dto.MenuRestaurantRequest;
import com.example.menuapi.model.dto.RestaurantRequest;
import com.example.menuapi.repo.MenuRepository;
import com.example.menuapi.service.MenuCategoryService;
import com.example.menuapi.service.MenuService;
import com.example.menuapi.service.RestaurantService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantService restaurantService;
    private final MenuCategoryService menuCategoryService;

    public MenuServiceImpl(MenuRepository menuRepository, @Lazy RestaurantService restaurantService, MenuCategoryService menuCategoryService) {
        this.menuRepository = menuRepository;
        this.restaurantService = restaurantService;
        this.menuCategoryService = menuCategoryService;
    }

    @Override
    public Menu createAndStoreMenu() {
        Menu menu = new Menu();
        return menuRepository.save(menu);
    }

    @Override
    public Menu saveMenu(MenuRestaurantRequest request) {
        RestaurantRequest restaurantRequest = RestaurantRequest.builder()
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .name(request.getNameRestaurant())
                .build();
        Restaurant restaurant = restaurantService.findByNameAndLocation(restaurantRequest);
        request.getMenuCategory()
                .forEach(menuCategoryRequest -> menuCategoryService.saveMenuCategory(menuCategoryRequest, restaurant.getMenu()));
        return null;
    }
}
