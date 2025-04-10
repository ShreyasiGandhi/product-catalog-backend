package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.dtos.CategoryDto;
import com.example.productcatalogservice.models.Category;
import com.example.productcatalogservice.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categorydto)
    {
        CategoryDto createdcategory = categoryService.createCategory(categorydto);
        return ResponseEntity.ok(createdcategory);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long Id)
    {
        CategoryDto category = categoryService.getCategoryById(Id);
        return ResponseEntity.ok(category);
    }
    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> getAllCategories()
    {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long id, @RequestBody CategoryDto categoryDto)
    {
        CategoryDto categoryDto1 = categoryService.updateCategory(id, categoryDto);
        return ResponseEntity.ok(categoryDto1);
    }
    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id)
    {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
