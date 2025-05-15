package com.example.session08.service;

import com.example.session08.model.Product;
import com.example.session08.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository repo;

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }

    @Override
    public Product getById(int id) {
        return repo.findById(id);
    }

    @Override
    public void save(Product p) {
        repo.save(p);
    }

    @Override
    public void update(Product p) {
        repo.update(p);
    }

    @Override
    public void delete(int id) {
        repo.delete(id);
    }

    @Override
    public List<Product> search(String name) {
        return repo.searchName(name);
    }
}
