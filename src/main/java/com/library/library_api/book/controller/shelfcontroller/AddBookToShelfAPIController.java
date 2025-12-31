package com.library.library_api.book.controller.shelfcontroller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library_api.book.dto.shelf.AddBookToShelfDto;
import com.library.library_api.book.exception.NoShelfFoundException;
import com.library.library_api.book.model.Shelf;
import com.library.library_api.book.service.shelf.AddBookToShelfService;

@RestController
@RequestMapping("/api/shelf/")
public class AddBookToShelfAPIController {
    @Autowired
    AddBookToShelfService addBookToShelfService;

    @PostMapping("{shelfId}/books/")
    public ResponseEntity<HashMap<String, Object>> addBookToShelf(
            @PathVariable Long shelfId,
            @RequestBody @Validated AddBookToShelfDto addBookToShelfDto) throws NoShelfFoundException {

        Shelf bookToShelf = addBookToShelfService.addBookToShelf(shelfId, addBookToShelfDto);
        HashMap<String, Long> responseData = new HashMap<>();
        responseData.put("shelfId", bookToShelf.getId());

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "Book added to shelf successfully");
        hashMap.put("data", responseData);
        return new ResponseEntity<>(hashMap, HttpStatus.CREATED);
    }
}
