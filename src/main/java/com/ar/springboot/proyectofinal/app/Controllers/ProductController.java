package com.ar.springboot.proyectofinal.app.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ar.springboot.proyectofinal.app.Model.Product;
import com.ar.springboot.proyectofinal.app.Services.ProductServiceImpl;

@Controller
public class ProductController {

    List<String> atributos = anyadirAntributos();
    private ProductServiceImpl service;

    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/products")
    public String mostrarProductos(Model model) {

        model.addAttribute("atributos", atributos);
        model.addAttribute("productos", service.findAll());

        return "products";
    }

    @GetMapping("/formNewProduct")
    public String formNewProduct(Model model) {

        model.addAttribute("producto", new Product(1L, "", 1L));
        return "formNewProduct";
    }

    @PostMapping("/formPostNewProduct")
    public String formNewProductPost(@ModelAttribute Product product, Model model) {

        service.create(product.getId(), product.getName(), product.getPrice());

        model.addAttribute("atributos", atributos);
        model.addAttribute("productos", service.findAll());

        return "redirect:/products";

    }

    @GetMapping("/formEditProduct")
    public String formEditProduct(@RequestParam("id") Long id, Model model) {
        Product product = service.findById(id);

        model.addAttribute("producto", product);

        return "formEditProduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute Product product) {
        service.update(product.getId(), product.getName(), product.getPrice());

        return "redirect:/products";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam("id") Long id, Model model) {

        Product product = service.findById(id);

        service.delete(product.getId());

        return "redirect:/products";
    }

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
