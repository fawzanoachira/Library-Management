package com.library.library_api.book.dto.shelf;

import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ShelfCreateDto {
    @Valid
    @NotNull(message = "user is required")
    private UUID userId;
    @NotEmpty(message = "name is required")
    private String name;
}
