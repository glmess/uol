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
        return new Book(isbn, "software engineering research methods");
    }
}
