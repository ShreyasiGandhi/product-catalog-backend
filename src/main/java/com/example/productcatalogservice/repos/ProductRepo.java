package com.example.productcatalogservice.repos;
import com.example.productcatalogservice.entity.ProductEntity;
import com.example.productcatalogservice.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity,Long> {
    ProductEntity save(ProductEntity product);

    Optional<ProductEntity> findById(Long id);

    void deleteById(Long id);

    List<ProductEntity> findAll();


    List<ProductEntity> findProductByOrderByPrice();




}


