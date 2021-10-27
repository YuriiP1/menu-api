package com.example.menuapi.repo;

import com.example.menuapi.model.Restaurant;
import com.example.menuapi.model.dto.RestaurantResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findByName(String name);

    Optional<Restaurant> findByIdAndName(Long id, String name);

    @Query("select new com.example.menuapi.model.dto.RestaurantResponse(res.name, res.location) from Restaurant res " +
            "order by res.id desc")
    List<RestaurantResponse> findAllNameAndLocation();
}
