package com.library.library_api.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_api.book.exception.NoBookFoundException;
import com.library.library_api.book.model.Book;
import com.library.library_api.book.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book createBook(Book book){
        Book save = bookRepository.save(book);
        return save;
    }

    public Book getBook(Long id) throws NoBookFoundException{
        Book orElseThrow = bookRepository.findById(id).orElseThrow(() -> new NoBookFoundException("No book found"));
        return orElseThrow;
    }
}
