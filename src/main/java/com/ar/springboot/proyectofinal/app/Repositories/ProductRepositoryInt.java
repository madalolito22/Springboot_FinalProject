package com.ar.springboot.proyectofinal.app.Repositories;

import java.util.List;

import com.ar.springboot.proyectofinal.app.Model.Product;

public interface ProductRepositoryInt {

    List<Product> findAll();

    Product findById(Long id);

}  