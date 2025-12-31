package com.library.library_api.book.dto.book;

import com.library.library_api.book.model.Book;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateBookDto {
    @Valid

    @NotEmpty(message = "title cannot be empty")
    private String title;
    @NotEmpty(message = "author cannot be empty")
    private String author;
    private String isbn;
    private String genre;
    private String description;

    public Book toBook() {
        return new Book()
                .setTitle(title)
                .setAuthor(author)
                .setIsbn(isbn)
                .setGenre(genre)
                .setDescription(description);
    }
}
