package com.ar.springboot.proyectofinal.app.Model;

public class Product {
   
    public Product() {
    }

    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
        priceWithTaxes = priceWithTaxes();
    }

    private Long id;
    private String name;
    private Long price;
    private Long priceWithTaxes;

    private Long priceWithTaxes(){
        return (long)(this.price * 1.21);
    }

}
