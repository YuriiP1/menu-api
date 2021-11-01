package com.example.menuapi.mapper;

import com.example.menuapi.model.MenuCategory;
import com.example.menuapi.model.dto.MenuCategoryRequest;
import org.mapstruct.Mapper;

@Mapper
public interface MenuCategoryMapper {
    MenuCategory convertRequestToEntity(MenuCategoryRequest menuCategoryRequest);
}
