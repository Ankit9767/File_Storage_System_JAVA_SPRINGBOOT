package com.example.FileStorageSystem.service;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.FileStorageSystem.model.File;
import com.example.FileStorageSystem.model.User;
import com.example.FileStorageSystem.repository.FileRepository;

@Service
public class FileService {

    private final Path fileStorageLocation = Paths.get("uploads");

    @Autowired
    private FileRepository fileRepository;

    public void storeFile(MultipartFile file, Long userId) {
        try {
            if (!Files.exists(fileStorageLocation)) {
                Files.createDirectories(fileStorageLocation);
            }

            String filename = file.getOriginalFilename();
            Path filePath = fileStorageLocation.resolve(filename);
            Files.copy(file.getInputStream(), filePath);

            File newFile = new File();
            newFile.setFilename(filename);
            newFile.setFilepath(filePath.toString());
            newFile.setUploadedAt(LocalDateTime.now());
            newFile.setVersion(1);
            newFile.setUser(new User(userId));

            fileRepository.save(newFile);
        } catch (Exception e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    public List<File> getAllFilesByUserId(Long userId) {
        return fileRepository.findByUserId(userId);
    }

    // Implement methods for downloading and versioning files
}
