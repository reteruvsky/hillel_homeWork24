package com.org.service;

import com.org.repository.ProductRepository;
import com.org.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class Cart {
    @Autowired
    ProductRepository productRepository;

    public Cart() {

    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void add(Product product) {
        productRepository.getProductList().add(product);
    }

    public boolean delete(Long id) {
        for (Product arr : productRepository.getProductList()) {
            if (id.equals(arr.getId())) {
                productRepository.getProductList().remove(arr);
                return true;
            }
        }
        return false;
    }
}
