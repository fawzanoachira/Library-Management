package com.library.library_api.book.controller.shelfcontroller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.library_api.book.dto.shelf.ShelfResponseDto;
import com.library.library_api.book.exception.NoShelfFoundException;
import com.library.library_api.book.model.Shelf;
import com.library.library_api.book.service.shelf.GetShelfService;

@RestController
@RequestMapping("/api/shelf/")
public class GetShelfAPIController {
    @Autowired
    GetShelfService getShelfService;

    @GetMapping("get-shelf")
    public ResponseEntity<HashMap<String, Object>> getBook(@RequestParam Long id) throws NoShelfFoundException{
        Shelf shelf = getShelfService.getShelf(id);
        ShelfResponseDto shelfResponseDto = new ShelfResponseDto(shelf);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "Shelf fetched successfully");
        hashMap.put("data", shelfResponseDto);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }
}
