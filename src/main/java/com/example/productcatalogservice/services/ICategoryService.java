package com.example.productcatalogservice.services;

import com.example.productcatalogservice.dtos.CategoryDto;

import java.util.List;

public interface ICategoryService {
    CategoryDto getCategoryById(Long id);
    List<CategoryDto> getAllCategories();
    CategoryDto createCategory(CategoryDto categoryDTO);
    CategoryDto updateCategory(Long id, CategoryDto categoryDTO);
    void deleteCategory(Long id);
}
