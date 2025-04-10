package com.example.productcatalogservice.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter

public class ProductDto {
    Long id;
    String name;
    String description;
    String imageUrl;
    Double price;
    CategoryDto category;
    Boolean isPrime;
}
