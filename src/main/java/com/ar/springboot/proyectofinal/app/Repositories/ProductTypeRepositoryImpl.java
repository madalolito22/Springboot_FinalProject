package com.ar.springboot.proyectofinal.app.Repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import com.ar.springboot.proyectofinal.app.Model.ProductType;

@Repository
@RequestScope
public class ProductTypeRepositoryImpl implements ProductTypeRepositoryInt {

    public List<ProductType> tipoProductos;

    public ProductTypeRepositoryImpl() {

    this.tipoProductos = new ArrayList<>(); 

    tipoProductos.add(new ProductType(1L, "Mesa", "Diferentes tipos de mesa para comedor"));
    tipoProductos.add(new ProductType(2L, "Televisor", "Módulos para poner un televisor"));
    tipoProductos.add(new ProductType(3L, "Silla", "Diferentes tipos de sillas y sillones"));
    tipoProductos.add(new ProductType(4L, "Sillón", "Tresillo, sofá modular y chaiselonge"));
}

    @Override
    public List<ProductType> findAll() {
        return tipoProductos;
    }

    @Override
    public ProductType findById(Long id) {

        ProductType found = null;

        for (ProductType p : tipoProductos) {

            if (p.getId().equals(id)) {

                found = p;

            }

        }

        return found;

    }

}
