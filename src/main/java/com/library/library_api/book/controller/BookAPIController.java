package com.library.library_api.book.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.library_api.book.dto.BookResponseDto;
import com.library.library_api.book.dto.CreateBookDto;
import com.library.library_api.book.dto.DeleteBookResponseDto;
import com.library.library_api.book.dto.UpdateBookDto;
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

    @GetMapping()
    public ResponseEntity<HashMap<String, Object>> getAllBooks() {
        List<Book> allBooks = bookService.getAllBooks();
        List<BookResponseDto> responseData = allBooks.stream()
                .map(book -> new BookResponseDto(book))
                .toList();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "Book fetched successfully");
        hashMap.put("data", responseData);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }

    @GetMapping("get-book")
    public ResponseEntity<HashMap<String, Object>> getBook(@RequestParam Long id) throws NoBookFoundException {
        Book book = bookService.getBook(id);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "Book fetched successfully");
        hashMap.put("data", book);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }

    @PatchMapping("update-book")
    public ResponseEntity<HashMap<String, Object>> updateBook(@RequestBody @Validated UpdateBookDto updateBookDto)
            throws NoBookFoundException {
        Book updateBook = bookService.updateBook(updateBookDto.toBook());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "Book fetched successfully");
        hashMap.put("data", updateBook);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }

    @DeleteMapping("delete-book/{id}")
    public ResponseEntity<HashMap<String, Object>> deleteBook(@PathVariable Long id) throws NoBookFoundException {
        Book deleteBook = bookService.deleteBook(id);
        DeleteBookResponseDto responseData = new DeleteBookResponseDto(deleteBook);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "Book deleted successfully");
        hashMap.put("data", responseData);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }
}
