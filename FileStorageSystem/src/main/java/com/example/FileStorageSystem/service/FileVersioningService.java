package com.example.FileStorageSystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FileStorageSystem.model.File;
import com.example.FileStorageSystem.repository.FileRepository;

@Service
public class FileVersioningService {

    @Autowired
    private FileRepository fileRepository;

    public void createNewVersion(File file) {
        File newVersion = new File();
        newVersion.setFilename(file.getFilename());
        newVersion.setFilepath(file.getFilepath());
        newVersion.setUser(file.getUser());
        newVersion.setVersion(file.getVersion() + 1);
        fileRepository.save(newVersion);
    }
}

