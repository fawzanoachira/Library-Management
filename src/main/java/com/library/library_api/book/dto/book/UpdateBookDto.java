package com.library.library_api.book.dto.book;

import com.library.library_api.book.model.Book;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateBookDto {
    @Valid

    @NotNull(message = "id is required")
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private String genre;
    private String description;

    public Book toBook() {
        return new Book()
                .setId(id)
                .setTitle(title)
                .setAuthor(author)
                .setIsbn(isbn)
                .setGenre(genre)
                .setDescription(description);
    }
}
