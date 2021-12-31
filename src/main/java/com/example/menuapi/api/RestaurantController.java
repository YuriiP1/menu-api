package com.example.menuapi.api;

import com.example.menuapi.model.Restaurant;
import com.example.menuapi.dto.RestaurantRequest;
import com.example.menuapi.dto.RestaurantResponse;
import com.example.menuapi.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<List<RestaurantResponse>> getAll(@RequestParam(value = "isMainPage", defaultValue = "true") boolean isMainPage) {
        return new ResponseEntity<>(restaurantService.getAll(isMainPage), HttpStatus.OK);
    }

    @GetMapping("/parameter")
    public ResponseEntity<Restaurant> getByIdOrName(@RequestParam(value = "id", required = false) Long id,
                                                    @RequestParam(value = "name") String name) {
        return new ResponseEntity<>(restaurantService.inquireBySelectedParameter(id, name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestaurantResponse> createRestaurant(@RequestBody @Validated RestaurantRequest request) {
        return new ResponseEntity<>(restaurantService.createAndStoreRestaurant(request), HttpStatus.OK);
    }
}
