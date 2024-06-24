package com.example.FileStorageSystem.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.FileStorageSystem.model.File;
import com.example.FileStorageSystem.service.FileService;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload/{userId}")
    public void uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Long userId) {
        fileService.storeFile(file, userId);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<File>> getAllFiles(@PathVariable Long userId) {
        List<File> files = fileService.getAllFilesByUserId(userId);
        return ResponseEntity.ok().body(files);
    }

    // Implement endpoints for downloading files, sharing files, and managing file versions
}
