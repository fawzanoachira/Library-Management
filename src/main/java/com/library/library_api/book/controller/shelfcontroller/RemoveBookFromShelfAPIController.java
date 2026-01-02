package com.library.library_api.book.controller.shelfcontroller;

import java.util.Collections;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library_api.book.dto.shelf.BookShelfDto;
import com.library.library_api.book.exception.NoBookFoundException;
import com.library.library_api.book.exception.NoShelfFoundException;
import com.library.library_api.book.service.shelf.RemoveBookFromShelfService;

@RestController
@RequestMapping("/api/shelf/")
public class RemoveBookFromShelfAPIController {
    @Autowired
    RemoveBookFromShelfService removeBookFromShelfService;

    @DeleteMapping("{shelfId}/books/")
    public ResponseEntity<HashMap<String, Object>> deleteBookFromShelf(
            @PathVariable Long shelfId,
            @RequestBody @Validated BookShelfDto bookShelfDto) throws NoShelfFoundException, NoBookFoundException {

        removeBookFromShelfService.removeBookFromShelf(shelfId, bookShelfDto);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "Book removed from shelf");
        hashMap.put("data", Collections.emptyMap());

        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }
}
