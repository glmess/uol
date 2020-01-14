package com.demo.bookpricingservice.models;


import java.util.List;

public class CustomerBookPurchasedPricing {

    private List<Pricing> customerBookPurchasedPricing;

    public List<Pricing> getCustomerBookPurchasedPricing() {
        return customerBookPurchasedPricing;
    }

    public void setCustomerBookPurchasedPricing(List<Pricing> customerBookPurchasedPricing) {
        this.customerBookPurchasedPricing = customerBookPurchasedPricing;
    }
}
