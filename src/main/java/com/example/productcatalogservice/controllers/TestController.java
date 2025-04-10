package com.example.productcatalogservice.controllers;

import com.example.productcatalogservice.config.ProductConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Value("${product.title}")
    private String title;
    @Value("${product.category}")
    private String category;
    @Value("${product.feature:false}")
    private boolean feature;
    @Autowired
    ProductConfig productConfig;

    @GetMapping()
    public void getTitle(){
        System.out.println(title +" "+feature);
        System.out.println(productConfig.getCount()+" "+productConfig.getImage()+" "+productConfig.isFeature());
          }
}
