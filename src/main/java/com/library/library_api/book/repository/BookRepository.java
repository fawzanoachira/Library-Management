package com.library.library_api.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.library_api.book.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
    
}
