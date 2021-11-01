package com.example.menuapi.mapper;

import com.example.menuapi.model.MenuItem;
import com.example.menuapi.model.dto.MenuItemRequest;
import com.example.menuapi.repo.MenuItemRepository;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MenuItemMapper {

    List<MenuItem> convertRequestToEntity(List<MenuItemRequest> request);
}
