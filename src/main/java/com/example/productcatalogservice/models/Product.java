package com.example.productcatalogservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    String name;
    String description;
    String imageUrl;
    Double price;
    Category category;
    Boolean isPrime;
    Long id;

}