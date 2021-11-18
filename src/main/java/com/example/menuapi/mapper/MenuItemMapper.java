package com.example.menuapi.mapper;

import com.example.menuapi.model.MenuItem;
import com.example.menuapi.dto.MenuItemRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MenuItemMapper {

    List<MenuItem> convertRequestToEntity(List<MenuItemRequest> request);
}
