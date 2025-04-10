package com.example.productcatalogservice.util;

import com.example.productcatalogservice.dtos.CategoryDto;
import com.example.productcatalogservice.entity.CategoryEntity;
import com.example.productcatalogservice.entity.ProductEntity;
import com.example.productcatalogservice.models.Category;
import com.example.productcatalogservice.models.Product;

public class CommonUtil {
     public static ProductEntity toProductEntity(Product product){
        ProductEntity p_entity = new ProductEntity();
        p_entity.setName(product.getName());
        p_entity.setDescription(product.getDescription());
        p_entity.setPrice(product.getPrice());
        p_entity.setIsPrime(product.getIsPrime());
        p_entity.setImageUrl(product.getImageUrl());
         // Do not directly map category from product DTO if it might result in duplicates.
         // Instead, only map the ID and later fetch the managed entity.
         if (product.getCategory() != null) {
             CategoryEntity categoryEntity = new CategoryEntity();
             categoryEntity.setId(product.getCategory().getId());
             // Optionally set only the ID – ignore other fields.
             p_entity.setCategory(categoryEntity);
         }
        return p_entity;
    }
    public static CategoryEntity toCategoryEntity(Category category)
    {
        CategoryEntity c_entity = new CategoryEntity();
        c_entity.setName(category.getName());
        c_entity.setDescription(category.getDescription());
        return c_entity;
    }
    public static Product fromProductEntity(ProductEntity productEntity){
        Product product = new Product();
        product.setName(productEntity.getName());
        product.setDescription(productEntity.getDescription());
        product.setPrice(productEntity.getPrice());
        product.setIsPrime(productEntity.getIsPrime());
        product.setImageUrl(productEntity.getImageUrl());
        product.setId(productEntity.getId());

        return product;
    }
    public static CategoryDto fromCategoryEntity(CategoryEntity categoryEntity)
    {
        CategoryDto category = new CategoryDto();
        category.setName(categoryEntity.getName());
        category.setDescription(categoryEntity.getDescription());
        return category;
    }

    // Convert CategoryEntity → CategoryDto
    public static CategoryDto toCategoryDTO(CategoryEntity entity) {
        return new CategoryDto(entity.getId(), entity.getName(), entity.getDescription());
    }

    // Convert CategoryDto → CategoryEntity
    public static CategoryEntity fromCategoryDto(CategoryDto dto) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(dto.getId());  // If ID is required
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        return entity;
    }

}
