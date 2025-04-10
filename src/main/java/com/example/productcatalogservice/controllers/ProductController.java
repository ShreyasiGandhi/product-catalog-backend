package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.entity.CategoryEntity;
import com.example.productcatalogservice.entity.ProductEntity;
import com.example.productcatalogservice.exception.ResourceNotFoundException;
import com.example.productcatalogservice.models.Category;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.productcatalogservice.util.CommonUtil.fromProductEntity;
import static com.example.productcatalogservice.util.CommonUtil.toProductEntity;


@RestController
public class ProductController {
    @Autowired
    private IProductService productService;
   // @PostMapping("/products")
   /* public Product createProduct(@RequestBody Product product)
    {

//ProductEntity productEntity = toProductEntity(product);
        return productService.createProduct(product);
    }*/
    @PostMapping("/categories/{categoryId}/products")
    public ResponseEntity<ProductDto> createProduct(
            @PathVariable Long categoryId,
            @RequestBody ProductDto productDto) throws ResourceNotFoundException {

        ProductDto createdProduct = productService.createProduct(categoryId, productDto);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable Long id) {

        return productService.getProductById(id); // Ensure a value is returned
    }

    @GetMapping("/products")
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtos = new ArrayList<>();
        List<Product> products = productService.getAllProducts();
        for(Product product : products)
        {
            productDtos.add(from(product));
        }
        return productDtos;
    }

    @PatchMapping("/products/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        Product product = from(productDto);
        product.setId(id); // Assuming you want to retain the ID
        return from(product);
    }

    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        return productDto; // Ensure a value is returned
    }

    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        return product; // Ensure a value is returned
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDto> createProductWithCategory(@RequestBody ProductDto productDto) {
        ProductDto createdProduct = productService.createProductWithCategory(productDto);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

}