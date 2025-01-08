package com.ar.springboot.proyectofinal.app.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.springboot.proyectofinal.app.Model.Product;
import com.ar.springboot.proyectofinal.app.Repositories.ProductRepositoryImpl;

@Service
public class ProductServiceImpl implements ProductServiceInt{

    private ProductRepositoryImpl repository;

    @Autowired
    public void setRepository(ProductRepositoryImpl repository){
        this.repository = repository;
    }

    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice()*1.21d;
            Product newProd = (Product) p.clone();
            p.setPrice(priceImp.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }

    @Override
    public Product create(Long id, String name, Long price) {
        return new Product(id, name, price);
    }

    @Override
    public Product update(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        repository.productos.remove(repository.findById(id));
    }

    
}