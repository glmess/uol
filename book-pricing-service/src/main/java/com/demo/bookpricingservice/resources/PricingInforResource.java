package com.demo.bookpricingservice.resources;

import com.demo.bookpricingservice.models.CustomerBookPurchasedPricing;
import com.demo.bookpricingservice.models.Pricing;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pricinginfo")
public class PricingInforResource {

    //API takes a book isbn and returns its price
    @RequestMapping("/{isbn}")
    public Pricing getPricing(@PathVariable("isbn") String isbn){
        return new Pricing(isbn, 30);
    }


    @RequestMapping("customers/{cust_id}")
    public CustomerBookPurchasedPricing getBookPurchasedPricing(@PathVariable("cust_id") String cust_id){
        List<Pricing> pricings = Arrays.asList(
                new Pricing("abc123", 45),
                new Pricing("def456", 25)
        );

        CustomerBookPurchasedPricing customerBookPurchasedPricing = new CustomerBookPurchasedPricing();
        customerBookPurchasedPricing.setCustomerBookPurchasedPricing(pricings);
        return customerBookPurchasedPricing;
    }
}
