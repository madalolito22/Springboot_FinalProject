package com.ar.springboot.proyectofinal.app.Repositories;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;
import com.ar.springboot.proyectofinal.app.Model.Product;

@Repository
@ApplicationScope  //No queremos que se creen productos para cada sesión o recarga de la página, esto guarda la ArrayList una vez solo para no clonar o sumar infinitamente el IVA.
public class ProductRepositoryImpl implements ProductRepositoryInt {

    private List<Product> productos = new ArrayList<>();

    @PostConstruct //Con esto hacemos que no se clonen los productos, y que solo se inicie una vez el constructor, después de ser inicializado.
    public void init() {
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
        for (Product p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void save(Product product) {
        productos.add(product);
    }

    public void delete(Product product) {
        productos.remove(product);
    }
}