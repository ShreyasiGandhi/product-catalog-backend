package com.example.productcatalogservice.services;

import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.exception.ResourceNotFoundException;
import com.example.productcatalogservice.models.Product;

import java.util.List;

public interface IProductService {
    Product getProductById(Long id);
    public List<Product> getAllProducts();
    Product replaceProduct(Product input,Long id);

    Boolean deleteProduct(Long id);

    //Product createProduct(Product productDto);
    ProductDto createProduct(Long categoryId, ProductDto productDto) throws ResourceNotFoundException;

   // Product createProduct(Product product);
   ProductDto createProductWithCategory(ProductDto productDto);
}
