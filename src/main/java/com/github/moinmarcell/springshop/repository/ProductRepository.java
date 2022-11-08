package com.github.moinmarcell.springshop.repository;

import com.github.moinmarcell.springshop.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    public ProductRepository(List<Product> products) {
        this.products = products;
    }

    public List<Product> list() {
        return products;
    }

    public Product get(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}