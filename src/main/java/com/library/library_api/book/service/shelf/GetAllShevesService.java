package com.library.library_api.book.service.shelf;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_api.book.model.Shelf;
import com.library.library_api.book.repository.ShelfRepository;

@Service
public class GetAllShevesService {
    @Autowired
    ShelfRepository shelfRepository;

    public List<Shelf> getAllShelf() {
        Iterable<Shelf> all = shelfRepository.findAll();
        List<Shelf> collect = StreamSupport.stream(all.spliterator(), false).collect(Collectors.toList());
        return collect;
    }
}
