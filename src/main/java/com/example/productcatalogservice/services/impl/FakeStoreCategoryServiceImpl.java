package com.example.productcatalogservice.services.impl;

import com.example.productcatalogservice.models.FakeStoreCategory;
import com.example.productcatalogservice.services.FakeStoreCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FakeStoreCategoryServiceImpl implements FakeStoreCategoryService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${dependencies.fakestore.url}")
    private String url;

    @Override
    public List<FakeStoreCategory> getAllCategories() {
        ResponseEntity<List<FakeStoreCategory>> response = restTemplate.exchange(url, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<FakeStoreCategory>>(){});
       // response.getBody().stream().map(FakeStoreCategory::getTitle).collect(Collectors.toList()).forEach(System.out::println);
        //response.getBody().stream().filter(m->m.getPrice()<150.00).collect(Collectors.toList()).forEach(System.out::println);
        String res = response.getBody().stream()
                .map(FakeStoreCategory::getTitle)
                .toList()
                .stream()
                .max(Comparator.comparing(String::length))
                .orElse("not found");
        System.out.println(res);
    return response.getBody();

    }


}
