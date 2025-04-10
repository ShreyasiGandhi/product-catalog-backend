package com.example.productcatalogservice.services.impl;

import com.example.productcatalogservice.dtos.CategoryDto;
import com.example.productcatalogservice.entity.CategoryEntity;
import com.example.productcatalogservice.repos.CategoryRepo;
import com.example.productcatalogservice.services.ICategoryService;
import com.example.productcatalogservice.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public CategoryDto getCategoryById(Long id) {
        Optional<CategoryEntity> category = categoryRepo.findById(id);
        assert category.orElse(null) != null;
        return CommonUtil.fromCategoryEntity(category.orElse(null));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryEntity> all = categoryRepo.findAll();
        return all.stream().map(CommonUtil::toCategoryDTO).collect(Collectors.toList());

    }


    @Override
    public CategoryDto createCategory(CategoryDto categoryDTO) {
        CategoryEntity categoryEntity = CommonUtil.fromCategoryDto(categoryDTO);
        // Convert back to DTO before returning
        return CommonUtil.toCategoryDTO(categoryRepo.save(categoryEntity));
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDTO) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
         categoryRepo.deleteById(id);
    }
}