package com.example.productcatalogservice.services;

import com.example.productcatalogservice.models.FakeStoreCategory;

import java.util.List;

public interface FakeStoreCategoryService {
    List<FakeStoreCategory> getAllCategories();
}
