# Microservices communication under the hood
This document provides details of how microservices based application are built and communicate using spring boot framework which from the analysis of my data sample emerged as the most popular one. In my illustration, I will be using a sample application made of 3 microservices that will communicate with each other to fulfill a specific end user request.

## Use case
The application basically provides a customer purchase history from a book store. The idea is that a user will provide a customerID and the application will make a number of API calls to backend microservices and return a customer purchase history.

**Example:**

Let's say we want to build a frontend application that will be accessed via the following endpoint: mypurchasehistory.com/api/georges

The application will accepts a customer ID  and return payload with a list of books purchased by that customer.

	{	cust_id: georges
		cust_name: Georges Essomba
		books: [
		{isbn: 1234, title:"research methods", desc: "research methods in software engineering", price: £30},
		{isbn: 5678, title:"AI/ML guide", desc: "Learn AI/ML from scratch", price: £50},
		]
	}

We can implement this using 3 microservices and then build the API for the 3 microservices to communicate.
	
## Step one: Building the microservices

The first we need to do is to create 3 spring boot projects for the 3 microservices of our application.

There are 3 ways to create spring boot project:

1. Using the web interface from: [https://start.spring.io/]()
2. Using the spring boot CLI 
3. Using build automation tool like maven or gradle

For this demonstration I will use option 2: sprint boot CLI. 

		(base) 186590dda78b:springboot gleschen$ spring init -d=web -n=customer-purchase-history-service --package-name=com.demo -j=13 customer-purchase-history-service
		Using service at https://start.spring.io
		Project extracted to '/Users/gleschen/springboot/customer-purchase-history-service'
		(base) 186590dda78b:springboot gleschen$ spring init -d=web -n=book-pricing-service --package-name=com.demo -j=13 book-pricing-service
		Using service at https://start.spring.io
		Project extracted to '/Users/gleschen/springboot/book-pricing-service'
		(base) 186590dda78b:springboot gleschen$ spring init -d=web -n=book-info-service --package-name=com.demo -j=13 book-info-service
		Using service at https://start.spring.io
		Project extracted to '/Users/gleschen/springboot/book-info-service'

The above commands create 3 spring boot projects: customer-purchase-history-service, book-pricing-service and book-info-service. Next I can import the projects into my IDE (Using IntelliJ IDEA Community Edition)

The code snippet below are our 3 mains sprint boot application:

Code for the customer-purchase-history

	package com.demo;
	
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	
	@SpringBootApplication
	public class CustomerPurchaseHistoryServiceApplication {
	
		public static void main(String[] args) {
			SpringApplication.run(CustomerPurchaseHistoryServiceApplication.class, args);
		}
	
	}

The second application book-info-service

	package com.demo;
	
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	
	@SpringBootApplication
	public class BookInfoServiceApplication {
	
		public static void main(String[] args) {
			SpringApplication.run(BookInfoServiceApplication.class, args);
		}
	
	}

The third application: book-pricing-service

	package com.demo;
	
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	
	@SpringBootApplication
	public class BookPricingServiceApplication {
	
		public static void main(String[] args) {
			SpringApplication.run(BookPricingServiceApplication.class, args);
		}
	
	}
We will add an API to customer-purchase-history-service at /history/{cust_id} that returns a list of books and pricing information

	package com.demo.customerpurchasehistoryservice.resources;
	
	
	import com.demo.customerpurchasehistoryservice.models.PurchaseHistoryItem;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	
	import java.util.Collections;
	import java.util.List;
	
	@RestController //make a rest controller
	@RequestMapping("/purchasehistory") //load BookPurchaseHistoryResource when a call is made to /purchasehistory
	public class BookPurchaseHistoryResource {
	
	    @RequestMapping("/{cust_id}") //load PurchaseHistoryItem when a call is made to /purchasehistory/{cust_id}
	    public List<PurchaseHistoryItem> getPurchaseHistory(@PathVariable("cust_id") String cust_id){
	
	        //harcoding a single purchase history
	        return Collections.singletonList(
	                new PurchaseHistoryItem(isbn: "12ab",  title: "software engineering research methods", desc: "software engineering research methods", 30)
	        );
	
	    }
	}

Now we will add an API to book-info-service at /books/{isbn} that returns a hard-coded book details

	package com.demo.bookinfoservice.resources;
	
	import com.demo.bookinfoservice.models.Book;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	
	
	@RestController
	@RequestMapping("/books")
	public class BookResource {
	
	    @RequestMapping("/{isbn}")
	    public Book getBookInfo(@PathVariable("isbn") String isbn){
	        return new Book(isbn, title: "software engineering research methods");
	    }
	}

Now adding an API to book-pricing-service at /pricinginfo/{isbn} that returns a hard-coded pricing of a book
	
	package com.demo.bookpricingservice.resources;
	
	import com.demo.bookpricingservice.models.Pricing;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	
	@RestController
	@RequestMapping("/pricinginfo")
	public class PricingInforResource {
	
	    @RequestMapping("/{isbn}")
	    public Pricing getPricing(@PathVariable("isbn") String isbn){
	        return new Pricing(isbn, 30);
	    }
	}
So far we have created 3 silos spring boot applications that have no awareness of each other as there is no communications between them.

## Step 2: setup communication between the three spring boot apps 
This step is about effectively converting our spring boot applications into microservices by setup communication between them through a number API calls.

**How to make a REST call** 

A Rest call be done in the following way:

1. Calling Rest API programmatically
2. Using a Rest client library
3. Spring boot comes with a client library in the classpath: RestTemplate

**Rest API to book-info-service**

The customer-purchase-history-service makes a Rest api call to the book-info-service. For each customer id that it receives, it gets the book isbn, title, description and pricing information

	package com.demo.customerpurchasehistoryservice.resources;
	
	
	import com.demo.customerpurchasehistoryservice.models.Book;
	import com.demo.customerpurchasehistoryservice.models.Pricing;
	import com.demo.customerpurchasehistoryservice.models.PurchaseHistoryItem;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.client.RestTemplate;
	
	import java.util.Arrays;
	import java.util.Collections;
	import java.util.List;
	import java.util.stream.Collectors;
	
	@RestController //make a rest controller
	@RequestMapping("/purchasehistory") //load BookPurchaseHistoryResource when a call is made to /purchasehistory
	public class BookPurchaseHistoryResource {
	
	    @RequestMapping("/{cust_id}") //load PurchaseHistoryItem when a call is made to /purchasehistory/{cust_id}
	    public List<PurchaseHistoryItem> getPurchaseHistory(@PathVariable("cust_id") String cust_id){
	
	        RestTemplate restTemplate = new RestTemplate();
	
	        //get a book payload and unmarshall into an object
	       // Book book = restTemplate.getForObject("http://localhost:8082/books/12ab", Book.class);
	
	        List<Pricing> pricings = Arrays.asList(
	                new Pricing("abc123", 45),
	                new Pricing("def456", 25)
	        );
	
	        //Rest API call to the book-info-service
	        return pricings.stream().map(pricing -> {
	            Book book = restTemplate.getForObject("http://localhost:8082/books/" + pricing.getIsbn(), Book.class);
	            return new PurchaseHistoryItem(book.getIsbn(), book.getTitle(), "Software engineering research methods", pricing.getPrice());
	        })
	         .collect(Collectors.toList());
	    }
	}
The inter-microservice communication is implemented using the following 3 lines of code:

	        return pricings.stream().map(pricing -> {
	            Book book = restTemplate.getForObject("http://localhost:8082/books/" + pricing.getIsbn(), Book.class);
	            return new PurchaseHistoryItem(book.getIsbn(), book.getTitle(), "Software engineering research methods", pricing.getPrice());
	        })
	    
This can be done in another way using WebClient that uses reactive web dependencies. The RestTemplate code would be replaced by the following code block to produce exactly the same result:

            Book book = getWebClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/books/" + pricing.getIsbn())
                    .retrieve()
                    .bodyToMono(Book.class)
                    .block();
            
            return new PurchaseHistoryItem(book.getIsbn(), book.getTitle(), "Software engineering research methods", pricing.getPrice());
        })

Basically the WebClient is using a builder pattern and return back a client. The get() means that we are doing a GET method. The uri() is the url where the request is to made. Retrieve simply tells WebClient to go and do it. Body to mono means whatever result you get from the GET request, convert it to book class. Finally, block() instructs web client to wait for execution and body to mono to put something into a container which is the provided Book class.

**API Call to book-pricing-service**

Next, we are going to make an API call to the book-pricing-service. This is implemented by the following code snippet:

	 CustomerBookPurchasedPricing pricings = restTemplate.getForObject("http://localhost:8083/pricinginfo/customers/" + cust_id, CustomerBookPurchasedPricing.class);
	                return pricings.getCustomerBookPurchasedPricing().stream().map(pricing -> {
	
	                    //For each book isbn call book-info-service and get details
	                    Book book = restTemplate.getForObject("http://localhost:8082/books/" + pricing.getIsbn(), Book.class);

We are making two API calls: the first one to get the list of books purchased by a customer and their associated pricing. The second API call gets the book isbn and details for each book.

	//Putting everything together
	return new PurchaseHistoryItem(book.getIsbn(), book.getTitle(), "Software engineering research methods", pricing.getPrice());

Finally the above line of code put the results of both API calls together and returns a list of books with all their details including isbn, title, description and pricing.
