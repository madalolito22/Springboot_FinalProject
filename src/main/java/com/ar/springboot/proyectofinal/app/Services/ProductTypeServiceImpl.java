package com.ar.springboot.proyectofinal.app.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ar.springboot.proyectofinal.app.Model.ProductType;
import com.ar.springboot.proyectofinal.app.Repositories.ProductTypeRepositoryImpl;

@Service
public class ProductTypeServiceImpl implements ProductTypeServiceInt{

    @Autowired
    private ProductTypeRepositoryImpl repository;

    @Autowired
    public void setRepository(ProductTypeRepositoryImpl repository){
        this.repository = repository;
    }

    public List<ProductType> findAll(){
        return repository.findAll().stream().map(p -> {
            ProductType newProdType = (ProductType) p.clone();
            return newProdType;
        }).collect(Collectors.toList());
    }

    public ProductType findById(Long id){
        return repository.findById(id);
    }

    @Override
    public ProductType create(Long id, String name, String description) {
        return new ProductType(id, name, description);
    }

    @Override
    public ProductType update(Long id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Long id) {
        repository.tipoProductos.remove(repository.findById(id));
    }

    
}