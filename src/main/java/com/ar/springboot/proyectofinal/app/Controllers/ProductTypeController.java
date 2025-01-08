package com.ar.springboot.proyectofinal.app.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.ar.springboot.proyectofinal.app.Model.ProductType;

@Controller
public class ProductTypeController {

    List<ProductType> tipoProductos = rellenarTipoProductos();

    private List<ProductType> rellenarTipoProductos() {

        ArrayList<ProductType> tipoProductos = new ArrayList<ProductType>();

        tipoProductos.add(new ProductType(1L, "Mesa", "Diferentes tipos de mesa para comedor"));
        tipoProductos.add(new ProductType(2L, "Televisor", "Módulos para poner un televisor"));
        tipoProductos.add(new ProductType(3L, "Silla", "Diferentes tipos de sillas y sillones"));
        tipoProductos.add(new ProductType(4L, "Sofá", "Tresllo, sofá modular y chaiselonge"));

        return tipoProductos;
    }

}
