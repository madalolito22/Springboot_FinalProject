package com.ar.springboot.proyectofinal.app.Model;

public class Product {

    public Long id;
    public String name;
    public Long price;
    public Long priceWithTaxes;

    public Product(long id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
        priceWithTaxes = priceWithTaxes();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getPriceWithTaxes() {
        return priceWithTaxes;
    }

    public void setPriceWithTaxes(Long priceWithTaxes) {
        this.priceWithTaxes = priceWithTaxes;
    }

    private Long priceWithTaxes() {
        return (long) (this.price * 1.21);
    }

    private String productTypeName(){
        return repository.
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return new Product(id, name, price);
        }
    }

}
