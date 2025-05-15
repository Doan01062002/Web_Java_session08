package com.example.session08.repository;

import com.example.session08.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    List<Product> findAll();
    Product findById(int id);
    void save(Product p);
    void update(Product p);
    void delete(int id);
    List<Product> searchName(String keyword);
}
