package com.librarysystem.server.dao;

import java.util.List;

import com.librarysystem.server.domain.CategoryEntity;

public interface CategoryDao
{
    // CREATE
    CategoryEntity create(CategoryEntity categoryEntity);

    // RETRIEVE
    CategoryEntity getById(long categoryId);

    CategoryEntity getCategoryEntityByCode(String categoryCode);

    List<CategoryEntity> getAllCategoryEntityList();

    // UPDATE
    CategoryEntity update(CategoryEntity categoryEntity);

    // DELETE
}
