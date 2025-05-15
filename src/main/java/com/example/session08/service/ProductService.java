package com.example.session08.service;

import com.example.session08.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    void save(Product p);
    void update(Product p);
    void delete(int id);
    List<Product> search(String name);
}