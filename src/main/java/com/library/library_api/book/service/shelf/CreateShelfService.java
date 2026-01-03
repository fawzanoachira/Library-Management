package com.library.library_api.book.service.shelf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_api.book.dto.shelf.ShelfCreateDto;
import com.library.library_api.book.model.Shelf;
import com.library.library_api.book.repository.ShelfRepository;
import com.library.library_api.user.exception.NoUserFoundException;
import com.library.library_api.user.model.User;
import com.library.library_api.user.service.UserService;

@Service
public class CreateShelfService {
    @Autowired
    ShelfRepository shelfRepository;

    @Autowired
    UserService userService;

    public Shelf createShelf(ShelfCreateDto shelfCreateDto) throws NoUserFoundException {
        User user = userService.getUser(shelfCreateDto.getUserId());
        Shelf shelf = new Shelf()
                .setName(shelfCreateDto.getName())
                .setUser(user);
        Shelf save = shelfRepository.save(shelf);
        return save;
    }
}
