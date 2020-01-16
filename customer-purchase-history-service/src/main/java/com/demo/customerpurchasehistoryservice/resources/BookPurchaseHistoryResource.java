package com.demo.customerpurchasehistoryservice.resources;


import com.demo.customerpurchasehistoryservice.models.Book;
import com.demo.customerpurchasehistoryservice.models.CustomerBookPurchasedPricing;
import com.demo.customerpurchasehistoryservice.models.Pricing;
import com.demo.customerpurchasehistoryservice.models.PurchaseHistoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController //make a rest controller
@RequestMapping("/purchasehistory") //load BookPurchaseHistoryResource when a call is made to /purchasehistory
public class BookPurchaseHistoryResource {

    //Consume a RestTemplate
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder getWebClientBuilder;

    @RequestMapping("/{cust_id}") //load PurchaseHistoryItem when a call is made to /purchasehistory/{cust_id}
    public List<PurchaseHistoryItem> getPurchaseHistory(@PathVariable("cust_id") String cust_id){

        CustomerBookPurchasedPricing pricings = restTemplate.getForObject("http://localhost:8083/pricinginfo/customers/" + cust_id, CustomerBookPurchasedPricing.class);
                return pricings.getCustomerBookPurchasedPricing().stream().map(pricing -> {

                    //For each book isbn call book-info-service and get details
                    Book book = restTemplate.getForObject("http://localhost:8082/books/" + pricing.getIsbn(), Book.class);
                    //Putting everything together
                    return new PurchaseHistoryItem(book.getIsbn(), book.getTitle(), "Software engineering research methods", pricing.getPrice());

                 })
                  .collect(Collectors.toList());
    }
}

//Create a builder using Web Client as alternative to RestTemplate to make API call
//WebClient.Builder builder = WebClient.builder();

//RestTemplate restTemplate = new RestTemplate();

//get a book payload and unmarshall into an object

        /*
        Book book = restTemplate.getForObject("http://localhost:8082/books/" + , Book.class);

        List<Pricing> pricings = Arrays.asList(
                new Pricing("abc123", 45),
                new Pricing("def456", 25)
        );

         */

//Get an instance of a book using WebClient
            /*
            Book book = getWebClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/books/" + pricing.getIsbn())
                    .retrieve()
                    .bodyToMono(Book.class)
                    .block();
             */