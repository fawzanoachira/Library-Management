package com.library.library_api.book.service.shelf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_api.book.exception.NoShelfFoundException;
import com.library.library_api.book.model.Shelf;
import com.library.library_api.book.repository.ShelfRepository;

@Service
public class GetShelfService {
    @Autowired
    ShelfRepository shelfRepository;

    public Shelf getShelf(Long id) throws NoShelfFoundException{
        Shelf shelf = shelfRepository.findById(id).orElseThrow(() -> new NoShelfFoundException("No shelf found under this id"));
        return shelf;
    }
}
