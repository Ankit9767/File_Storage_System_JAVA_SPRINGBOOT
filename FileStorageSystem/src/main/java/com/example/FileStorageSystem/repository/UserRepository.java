package com.example.FileStorageSystem.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FileStorageSystem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
