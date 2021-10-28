package com.example.menuapi.api;

import com.example.menuapi.model.Restaurant;
import com.example.menuapi.model.dto.RestaurantRequest;
import com.example.menuapi.model.dto.RestaurantResponse;
import com.example.menuapi.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @GetMapping("/getAll")
    public ResponseEntity<List<Restaurant>> getAll(@RequestParam(value = "isMainPage", defaultValue = "true") boolean isMainPage) {
        return new ResponseEntity<>(restaurantService.getAll(isMainPage), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Restaurant> getByIdOrName(@RequestParam(value = "id", required = false) Long id,
                                                    @RequestParam(value = "name", required = false) String name) {
        return new ResponseEntity<>(restaurantService.inquireBySelectedParameter(id, name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RestaurantResponse> createRestaurant(@RequestBody @Validated RestaurantRequest request) {
        return new ResponseEntity<>(restaurantService.createAndStoreRestaurant(request), HttpStatus.OK);
    }
}
