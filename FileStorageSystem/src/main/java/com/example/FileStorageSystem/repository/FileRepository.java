package com.example.FileStorageSystem.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FileStorageSystem.model.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

    List<File> findByUserId(Long userId);
}

