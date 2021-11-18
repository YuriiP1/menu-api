package com.example.menuapi.api;

import com.example.menuapi.model.Menu;
import com.example.menuapi.dto.MenuRestaurantRequest;
import com.example.menuapi.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody MenuRestaurantRequest request) {
        return new ResponseEntity<>(menuService.saveMenu(request), HttpStatus.OK);
    }
}
