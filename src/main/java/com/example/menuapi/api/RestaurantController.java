package com.example.menuapi.api;

import com.example.menuapi.model.Restaurant;
import com.example.menuapi.service.RestaurantService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
}
