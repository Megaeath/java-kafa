
package com.rest.API.controller;

import com.rest.API.exception.BookNotFoundException;
import com.rest.API.model.Book;
import com.rest.API.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/book")
    public List<Book> getAllNotes() {
        return bookRepository.findAll();
    }
}