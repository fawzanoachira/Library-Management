package com.library.library_api.book.controller.shelfcontroller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library_api.book.model.Shelf;
import com.library.library_api.book.service.shelf.GetAllShevesService;

@RestController
@RequestMapping("/api/shelf/")
public class GetAllShelfAPIController {
    @Autowired
    GetAllShevesService getAllShevesService;
    
    @GetMapping()
    public ResponseEntity<HashMap<String, Object>> getAllShelves(){
        List<Shelf> allShelf = getAllShevesService.getAllShelf();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "All shelves fetched successfully");
        hashMap.put("data", allShelf);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }
}
