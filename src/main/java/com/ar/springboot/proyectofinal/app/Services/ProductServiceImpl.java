package com.ar.springboot.proyectofinal.app.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.springboot.proyectofinal.app.Model.Product;
import com.ar.springboot.proyectofinal.app.Repositories.ProductRepositoryImpl;

@Service
public class ProductServiceImpl implements ProductServiceInt{

    @Autowired
    private ProductRepositoryImpl repository;

    @Autowired
    public void setRepository(ProductRepositoryImpl repository){
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            p.priceWithTaxes();
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }

    @Override
    public void create(Long id, String name, Long price) {
        Product newProduct = new Product(id, name, price);
        repository.save(newProduct);
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id));
    }

    @Override
    public void update(Long id, String name, Long price) {
        repository.findById(id).setPrice(price);
        repository.findById(id).setName(name);
    }

}