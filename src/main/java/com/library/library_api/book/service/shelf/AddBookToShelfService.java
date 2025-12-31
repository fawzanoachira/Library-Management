package com.library.library_api.book.service.shelf;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_api.book.dto.shelf.AddBookToShelfDto;
import com.library.library_api.book.exception.NoShelfFoundException;
import com.library.library_api.book.model.Book;
import com.library.library_api.book.model.Shelf;
import com.library.library_api.book.repository.BookRepository;
import com.library.library_api.book.repository.ShelfRepository;

@Service
public class AddBookToShelfService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    GetShelfService getShelfService;

    @Autowired
    ShelfRepository shelfRepository;

    public Shelf addBookToShelf(Long shelfId, AddBookToShelfDto addBookToShelfDto) throws NoShelfFoundException{
        Shelf shelf = getShelfService.getShelf(shelfId);
        Book book = bookRepository.findById(addBookToShelfDto.getBookId()).get();
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(book);
        shelf.setBook(listOfBooks);

        Shelf save = shelfRepository.save(shelf);
        return save;
    }
}