package com.demo.customerpurchasehistoryservice.models;

public class PurchaseHistoryItem {

    private String isbn;
    private String title;
    private String desc;
    private int price;

    public PurchaseHistoryItem(String isbn, String title, String desc, int price) {
        this.isbn = isbn;
        this.title = title;
        this.desc = desc;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
