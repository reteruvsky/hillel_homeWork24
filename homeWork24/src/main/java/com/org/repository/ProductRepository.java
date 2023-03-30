package com.org.repository;

import com.org.entity.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProductById(Long id) {
        for (Product arr : productList) {
            if (arr.getId().equals(id)) {
                return arr;
            }
        }
        return null;
    }

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(new Product(1L, "Beer", 4.0),
                new Product(2L, "Gin", 25.5),
                new Product(3L, "Tonic", 2.2),
                new Product(4L, "Salmon", 30.0),
                new Product(5L, "Pistachios", 7.2)));
    }
}
