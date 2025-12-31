package com.library.library_api.book.controller.shelfcontroller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library_api.book.dto.shelf.ShelfCreateDto;
import com.library.library_api.book.model.Shelf;
import com.library.library_api.book.service.shelf.CreateShelfService;
import com.library.library_api.user.exception.NoUserFoundException;

@RestController
@RequestMapping("/api/shelf/")
public class CreateShelfAPIController {
    @Autowired
    CreateShelfService createShelfService;

    @PostMapping("create")
    public ResponseEntity<HashMap<String, Object>> createShelf(@RequestBody @Validated ShelfCreateDto shelfCreateDto) throws NoUserFoundException {
        Shelf shelf = createShelfService.createShelf(shelfCreateDto);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "Shelf created successfully");
        hashMap.put("data", shelf);
        return new ResponseEntity<>(hashMap, HttpStatus.CREATED);
    }
}
