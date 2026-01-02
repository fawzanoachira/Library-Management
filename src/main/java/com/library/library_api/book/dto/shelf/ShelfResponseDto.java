package com.library.library_api.book.dto.shelf;

import java.util.List;

import com.library.library_api.book.dto.book.BookResponseDto;
import com.library.library_api.book.model.Shelf;
import com.library.library_api.user.dto.UserResponseDto;

import lombok.Data;

@Data
public class ShelfResponseDto {
    private Long id;
    private UserResponseDto user;
    private String name;
    private List<BookResponseDto> book;

    public ShelfResponseDto(Shelf allShelf) {
        this.id = allShelf.getId();
        this.user = new UserResponseDto(allShelf.getUser());
        this.name = allShelf.getName();
        this.book = allShelf.getBook().stream().map(book -> new BookResponseDto(book)).toList();
        this.id = allShelf.getId();
    }
}
