package com.example.productcatalogservice.services.impl;

import com.example.productcatalogservice.dtos.ProductDto;
import com.example.productcatalogservice.entity.CategoryEntity;
import com.example.productcatalogservice.entity.ProductEntity;
import com.example.productcatalogservice.exception.ResourceNotFoundException;
import com.example.productcatalogservice.models.Category;
import com.example.productcatalogservice.models.Product;
import com.example.productcatalogservice.repos.CategoryRepo;
import com.example.productcatalogservice.repos.ProductRepo;
import com.example.productcatalogservice.services.IProductService;
import com.example.productcatalogservice.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService
{
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Product getProductById(Long id) {
        Optional<ProductEntity> product= productRepo.findById(id);
        assert product.orElse(null) != null;
        return CommonUtil.fromProductEntity(product.orElse(null));
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product replaceProduct(Product input, Long id) {
        return null;
    }

    @Override
    public Boolean deleteProduct(Long id) {
        return null;
    }

    @Override
    public ProductDto createProduct(Long categoryId, ProductDto productDto) throws ResourceNotFoundException {

        // 1. Fetch Category from DB
        CategoryEntity category = categoryRepo.findById(categoryId).orElse(null);

        if (category == null) {
            throw new ResourceNotFoundException("Category Not Found with id: " + categoryId);
        }
        // 2. Map ProductDto to ProductEntity
        ProductEntity product = new ProductEntity();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setIsPrime(productDto.getIsPrime());

        // 3. Set Category to Product
        product.setCategory(category);

        // 4. Save Product
        ProductEntity savedProduct = productRepo.save(product);

        // 5. Convert Entity to Dto & Return
        return mapToDto(savedProduct);
    }

   /* @Override
    public Product createProduct(Product product) {
        //Product entity = productRepo.save(product);
        Category category = product.getCategory();
        CategoryEntity savedCategory = categoryRepo.save(CommonUtil.toCategoryEntity(category));
        ProductEntity productEntity = CommonUtil.toProductEntity(product);
        productEntity.setCategory(savedCategory);
        ProductEntity savedProduct = productRepo.save(productEntity);
        return CommonUtil.fromProductEntity(savedProduct);
    }*/
   private ProductDto mapToDto(ProductEntity product) {
       ProductDto dto = new ProductDto();
       dto.setId(product.getId());
       dto.setName(product.getName());
       dto.setDescription(product.getDescription());
       dto.setPrice(product.getPrice());
       dto.setImageUrl(product.getImageUrl());
       dto.setIsPrime(product.getIsPrime());
       dto.setName(product.getCategory().getName());
       return dto;
   }

    @Override
    public ProductDto createProductWithCategory(ProductDto productDto) {

        // 1. Check if category already exists
        CategoryEntity category = categoryRepo.findByName(productDto.getCategory().getName());

        // 2. If category doesn't exist, create new
        if (category == null) {
            CategoryEntity newCategory = new CategoryEntity();
            newCategory.setName(productDto.getCategory().getName());
            newCategory.setDescription(productDto.getCategory().getDescription());
            category = Optional.ofNullable(categoryRepo.save(newCategory));
        }

        // 3. Create Product
        ProductEntity product = new ProductEntity();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setIsPrime(productDto.getIsPrime());
        product.setCategory(category);  // Associate Product with Category

        ProductEntity savedProduct = productRepo.save(product);

        return mapToDto(savedProduct);  // Or manually map
    }

}
