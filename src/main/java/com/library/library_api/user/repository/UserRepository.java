package com.library.library_api.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.library_api.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    public Boolean existsByEmail(String email);
    public Optional<User> findByEmail(String email);
    public Boolean existsByEmailAndIdNot(String email, UUID id);
}
