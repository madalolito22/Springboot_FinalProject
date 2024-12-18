package com.ar.springboot.proyectofinal.app.Model;

public class Product {
   
    private Long id;
    private String name;
    private Long price;

    public Long priceWithTaxes(){
        return 2L;
    }

}
