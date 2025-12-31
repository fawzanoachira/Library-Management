package com.library.library_api.book.dto.shelf;

import com.library.library_api.book.annotations.BookFOundOrNot;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddBookToShelfDto {
    @Valid
    @NotNull(message = "bookId is required")
    @BookFOundOrNot
    private Long bookId;
}
