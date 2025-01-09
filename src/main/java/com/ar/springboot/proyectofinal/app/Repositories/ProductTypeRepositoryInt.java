package com.ar.springboot.proyectofinal.app.Repositories;

import java.util.List;

import com.ar.springboot.proyectofinal.app.Model.ProductType;

public interface ProductTypeRepositoryInt {

    List<ProductType> findAll();

    ProductType findById(Long id);

}  