package com.example.productcatalogservice.entity;

import com.example.productcatalogservice.models.Category;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String description;
    String imageUrl;
    Double price;

    Boolean isPrime;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) // Foreign key column
    private CategoryEntity category;

}
