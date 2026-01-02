package com.library.library_api.book.service.shelf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_api.book.dto.shelf.BookShelfDto;
import com.library.library_api.book.exception.NoBookFoundException;
import com.library.library_api.book.exception.NoShelfFoundException;
import com.library.library_api.book.model.Book;
import com.library.library_api.book.model.Shelf;
import com.library.library_api.book.repository.ShelfRepository;
import com.library.library_api.book.service.BookService;

@Service
public class RemoveBookFromShelfService {
    @Autowired
    ShelfRepository shelfRepository;

    @Autowired
    GetShelfService getShelfService;

    @Autowired
    BookService bookService;

    public Shelf removeBookFromShelf(Long shelfId, BookShelfDto bookShelfDto)
            throws NoShelfFoundException, NoBookFoundException {
        Shelf shelf = getShelfService.getShelf(shelfId);
        Book book = bookService.getBook(bookShelfDto.getBookId());
        List<Book> booksInShelf = shelf.getBook();

        if (booksInShelf.stream().anyMatch(listOfBook -> book.getId().equals(listOfBook.getId()))) {
            booksInShelf.remove(book);
        } else {
        }

        Shelf save = shelfRepository.save(shelf);
        return save;
    }
}
