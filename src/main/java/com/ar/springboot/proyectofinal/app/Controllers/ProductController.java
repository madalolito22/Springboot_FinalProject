package com.ar.springboot.proyectofinal.app.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ar.springboot.proyectofinal.app.Model.Product;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    List<Product> productos = anyadirProductos();

    @GetMapping("/products")
    public String mostrarProductos(Model model) {

        List<String> atributos = anyadirAntributos();

        model.addAttribute("atributos", atributos);
        model.addAttribute("productos", productos);

        return "products";
    }

    @GetMapping("/formNewProduct")
    public String formNewProduct(Model model) {
        model.addAttribute("producto", new Product(null, null, null));
        return "formNewProduct";
    }

    @PostMapping("/formPostNewProduct")
    public void formNewProductPost(@ModelAttribute Product product) {
        productos.add(product);
    }

    private List<Product> anyadirProductos() {
        List<Product> productos= new ArrayList<Product>();

        productos.add(new Product(1L, "Mesa Circular Razor", 200L));
        productos.add(new Product(2L, "Módulo televisor Sinair", 850L));
        productos.add(new Product(3L, "Silla metálica Candy", 180L));
        productos.add(new Product(4L, "Sillón chaiselonge Roma", 1200L));
    
        return productos;
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
