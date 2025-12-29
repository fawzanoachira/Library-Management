package com.library.library_api.book.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.library_api.book.dto.CreateBookDto;
import com.library.library_api.book.exception.NoBookFoundException;
import com.library.library_api.book.model.Book;
import com.library.library_api.book.service.BookService;

@RestController
@RequestMapping("/api/books/")
public class BookAPIController {
    @Autowired
    BookService bookService;

    @PostMapping("create")
    public ResponseEntity<HashMap<String, Object>> createBook(@RequestBody @Validated CreateBookDto createBookDto) {
        Book book = bookService.createBook(createBookDto.toBook());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "Book created successfully");
        hashMap.put("data", book);
        return new ResponseEntity<>(hashMap, HttpStatus.CREATED);
    }

    @GetMapping("get-book")
    public ResponseEntity<HashMap<String, Object>> getBook(@RequestParam Long id) throws NoBookFoundException{
        Book book = bookService.getBook(id);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "Book fetched successfully");
        hashMap.put("data", book);
        return new ResponseEntity<>(hashMap, HttpStatus.CREATED);
    }
}
