package com.example.productcatalogservice.models;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category extends BaseModel {

    String name;
    String description;
    List<Product> products;
}