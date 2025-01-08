package com.ar.springboot.proyectofinal.app.Services;

import java.util.List;

import com.ar.springboot.proyectofinal.app.Model.Product;

public interface ProductServiceInt {
    
    List<Product> findAll();

    Product findById(Long id);

    Product create(Long id, String name, Long price);

    Product update(Long id);

    void delete(Long id);

}
