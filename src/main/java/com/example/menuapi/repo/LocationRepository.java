package com.example.menuapi.repo;

import com.example.menuapi.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findById(Location location);
}
