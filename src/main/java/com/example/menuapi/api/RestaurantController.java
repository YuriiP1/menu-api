package com.example.menuapi.api;

import com.example.menuapi.model.Restaurant;
import com.example.menuapi.model.dto.RestaurantRequest;
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

    @GetMapping("/getAll")
    public ResponseEntity<List<Restaurant>> getAll() {
        return new ResponseEntity<>(restaurantService.getAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Restaurant> getByIdOrName(@RequestParam(value = "id", required = false) Long id,
                                                    @RequestParam(value = "name", required = false) String name) {
        return new ResponseEntity<>(restaurantService.inquireBySelectedParameter(id, name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody @Validated RestaurantRequest request) {
        return new ResponseEntity<>(restaurantService.createAndStoreRestaurant(request), HttpStatus.OK);
    }

//        @GetMapping("/{id}")
//    public ResponseEntity<Restaurant> getById(@PathVariable(value = "id") Long id) {
//        return new ResponseEntity<>(restaurantService.getById(id), HttpStatus.OK);
//    }
//
//    @GetMapping("/{name}")
//    public ResponseEntity<Restaurant> getByName(@PathVariable(value = "name") String name) {
//        return new ResponseEntity<>(restaurantService.getByName(name), HttpStatus.OK);
//    }
}
