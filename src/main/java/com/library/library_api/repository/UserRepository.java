package com.library.library_api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.library_api.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    public Boolean existsByEmail(String email);
}
