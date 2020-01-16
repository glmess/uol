package com.demo.customerpurchasehistoryservice.models;

public class Pricing {
    private String isbn;
    private int price;


    public Pricing() {
    }

    public Pricing(String isbn, int price) {
        this.isbn = isbn;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
