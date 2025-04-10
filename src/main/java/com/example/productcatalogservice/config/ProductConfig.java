package com.example.productcatalogservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@ConfigurationProperties(prefix = "product")
@Data
public class ProductConfig {
    String title;
    String category;
    String image;
    Integer count;
    boolean feature;
}
