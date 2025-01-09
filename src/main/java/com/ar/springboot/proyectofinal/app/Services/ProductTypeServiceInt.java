package com.ar.springboot.proyectofinal.app.Services;

import java.util.List;

import com.ar.springboot.proyectofinal.app.Model.ProductType;

public interface ProductTypeServiceInt {
    
    List<ProductType> findAll();

    ProductType findById(Long id);

    ProductType create(Long id, String name, String description);

    ProductType update(Long id);

    void delete(Long id);

}
