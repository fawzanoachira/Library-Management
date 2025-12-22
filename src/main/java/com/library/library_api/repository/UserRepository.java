package com.library.library_api.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.library_api.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, UUID>{
    public User isEmailAlreadyInUse(String email);
}
