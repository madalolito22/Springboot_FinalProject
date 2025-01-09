package com.ar.springboot.proyectofinal.app.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ar.springboot.proyectofinal.app.Services.ProductTypeServiceImpl;

@Controller
public class ProductTypeController {

    private ProductTypeServiceImpl service;

     public ProductTypeController(ProductTypeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/productTypes")
    public String mostrarProductos(Model model) {

        List<String> atributos = anyadirAntributos();

        model.addAttribute("atributos", atributos);
        model.addAttribute("tipoProductos", service.findAll());

        return "productTypes";
    }

    private List<String> anyadirAntributos() {

        List<String> atributos = new ArrayList<>();

        atributos.add("Id");
        atributos.add("Nombre");
        atributos.add("Descripcion");

        return atributos;

    }

}
