package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.models.FakeStoreCategory;
import com.example.productcatalogservice.services.FakeStoreCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fake")
public class FakeController {
    @Autowired
    FakeStoreCategoryService fakeStoreCategoryService;

    @GetMapping()
    public List<FakeStoreCategory> getProductsByCategory(){
        return fakeStoreCategoryService.getAllCategories();

    }

}
