package com.library.library_api.book.dto;

import com.library.library_api.book.model.Book;

import lombok.Data;

@Data
public class DeleteBookResponseDto {
    private Long id;
    private String title;
    private String isbn;
    private String author;
    private String description;
    private String genre;

    public DeleteBookResponseDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
        this.genre = book.getGenre();
        this.description = book.getDescription();
    }
}
