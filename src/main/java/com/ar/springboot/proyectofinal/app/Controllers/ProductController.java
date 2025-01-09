package com.ar.springboot.proyectofinal.app.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ar.springboot.proyectofinal.app.Model.Product;
import com.ar.springboot.proyectofinal.app.Services.ProductServiceImpl;

@Controller
public class ProductController {

    private ProductServiceImpl service;

    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/products")
    public String mostrarProductos(Model model) {

        List<String> atributos = anyadirAntributos();

        model.addAttribute("atributos", atributos);
        model.addAttribute("productos", service.findAll());

        return "products";
    }

    @GetMapping("/formNewProduct")
    public String formNewProduct(Model model) {
        model.addAttribute("producto", new Product(1L, "null", 1L));
        return "formNewProduct";
    }

    // @PostMapping("/formPostNewProduct")
    // public void formNewProductPost(@ModelAttribute Product product) {
    //     productos.add(product);
    // }

    private List<String> anyadirAntributos() {

        List<String> atributos = new ArrayList<>();

        atributos.add("Id");
        atributos.add("Nombre");
        atributos.add("Tipo de Producto");
        atributos.add("Precio");
        atributos.add("Precio Con IVA");
        atributos.add("Acciones");

        return atributos;

    }

}
