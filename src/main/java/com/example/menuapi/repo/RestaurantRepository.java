package com.example.menuapi.repo;

import com.example.menuapi.model.Restaurant;
import com.example.menuapi.dto.RestaurantResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("select restaurant from Restaurant restaurant " +
            "left join fetch restaurant.location " +
            "left join fetch restaurant.menu")
    List<Restaurant> getAllBy();

    Optional<Restaurant> findByName(String name);

    Optional<Restaurant> findByIdAndName(Long id, String name);

    @Query("select new com.example.menuapi.dto.RestaurantResponse(res.name, res.location) from Restaurant res " +
            "order by res.id desc")
    List<RestaurantResponse> findAllNameAndLocation();

    @Query("select res from Restaurant res, Location loc where res.name = :name " +
            "and loc.latitude = :latitude " +
            "and loc.longitude = :longitude")
    Optional<Restaurant> findByNameAndLatitudeAndLongitude(@RequestParam(name = "name") String name, @RequestParam(name = "latitude") String latitude, @RequestParam("longitude") String longitude);
}
