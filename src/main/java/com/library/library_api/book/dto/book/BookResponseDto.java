package com.library.library_api.book.dto.book;

import com.library.library_api.book.model.Book;

import lombok.Data;

@Data
public class BookResponseDto {
    private Long id;
    private String title;
    private String isbn;
    private String author;
    private String description;
    private String genre;

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
        this.genre = book.getGenre();
        this.description = book.getDescription();
    }
}
