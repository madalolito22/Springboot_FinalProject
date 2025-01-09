package com.ar.springboot.proyectofinal.app.Services;

import java.util.List;

import com.ar.springboot.proyectofinal.app.Model.Product;

public interface ProductServiceInt {
    
    List<Product> findAll();

    Product findById(Long id);

    void create(Long id, String name, Long price);

    void update(Long id, String name, Long price);

    void delete(Long id);

}
