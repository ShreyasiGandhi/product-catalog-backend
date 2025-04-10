package com.example.productcatalogservice.repos;

import com.example.productcatalogservice.dtos.CategoryDto;
import com.example.productcatalogservice.entity.CategoryEntity;
import com.example.productcatalogservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface CategoryRepo extends JpaRepository<CategoryEntity,Long> {
    Optional<CategoryEntity> findById(Long id);
    CategoryEntity save(CategoryEntity category);
    Optional<CategoryEntity> findByName(String name);
}
