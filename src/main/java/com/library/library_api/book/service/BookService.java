package com.library.library_api.book.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_api.book.exception.NoBookFoundException;
import com.library.library_api.book.model.Book;
import com.library.library_api.book.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book createBook(Book book) {
        Book save = bookRepository.save(book);
        return save;
    }

    public List<Book> getAllBooks() {
        Iterable<Book> all = bookRepository.findAll();
        List<Book> collect = StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
        return collect;
    }

    public Book getBook(Long id) throws NoBookFoundException {
        Book orElseThrow = bookRepository.findById(id).orElseThrow(() -> new NoBookFoundException("No book found"));
        return orElseThrow;
    }

    public Book updateBook(Book book) throws NoBookFoundException {
        Book bookFetched = bookRepository.findById(book.getId())
                .orElseThrow(() -> new NoBookFoundException("No book found"));
        bookFetched.setTitle(book.getTitle() != null ? book.getTitle() : bookFetched.getTitle());
        bookFetched.setAuthor(book.getAuthor() != null ? book.getAuthor() : bookFetched.getAuthor());
        bookFetched.setDescription(book.getDescription() != null ? book.getDescription() : bookFetched.getDescription());
        bookFetched.setIsbn(book.getIsbn() != null  ? book.getIsbn() : bookFetched.getIsbn());
        bookFetched.setGenre(book.getGenre() != null  ? book.getGenre() : bookFetched.getGenre());
        Book save = bookRepository.save(bookFetched);
        return save;
    }

    public Book deleteBook(Long id) throws NoBookFoundException{
        Book bookFetched = bookRepository.findById(id).orElseThrow(() -> new NoBookFoundException("No book found"));
        bookRepository.delete(bookFetched);
        return bookFetched;
    }
}
