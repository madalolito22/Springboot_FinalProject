package com.ar.springboot.proyectofinal.app.Repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import com.ar.springboot.proyectofinal.app.Model.Product;

@Repository
@RequestScope
public class ProductRepositoryImpl implements ProductRepositoryInt {

    public List<Product> productos;

    public ProductRepositoryImpl() {

    this.productos = new ArrayList<>(); 

    productos.add(new Product(1L, "Mesa Circular Razor", 200L));
    productos.add(new Product(2L, "Módulo televisor Sinair", 850L));
    productos.add(new Product(3L, "Silla metálica Candy", 180L));
    productos.add(new Product(4L, "Sillón chaiselonge Roma", 1200L));
}

    @Override
    public List<Product> findAll() {
        return productos;
    }

    @Override
    public Product findById(Long id) {

        Product found = null;

        for (Product p : productos) {

            if (p.getId().equals(id)) {

                found = p;

            }

        }

        return found;

    }

}
