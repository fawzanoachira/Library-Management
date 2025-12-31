package com.library.library_api.book.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.library_api.book.model.Shelf;

@Repository
public interface ShelfRepository extends CrudRepository<Shelf, Long> {

}
