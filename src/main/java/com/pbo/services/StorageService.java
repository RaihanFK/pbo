package com.pbo.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;

@Service 
public class StorageService {

    @Value("${upload.folder}")
    private String folder;

    @PostConstruct
    public void init() {
        try {
            System.out.println("Configured folder: " + folder);
            Path path = Paths.get(folder).toAbsolutePath();
            if (Files.notExists(path)) {
                System.out.println("Folder doesn't exist, creating it...");
                Files.createDirectories(path); 
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing StorageService: " + e.getMessage(), e);
        }
    }


    public void validateCoverHeader(MultipartFile file) {
        if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png") && !file.getContentType().equals("image/jpg")) {
            throw new IllegalArgumentException("File type must be JPEG or PNG or JPG");
        }
    }

    public String writeFile(MultipartFile file) throws IOException {
        String filename = System.currentTimeMillis() + formatFilename(file.getOriginalFilename());
        Path filePath = Paths.get(folder, filename);

        try (FileOutputStream fos = new FileOutputStream(filePath.toFile())) {
            fos.write(file.getBytes());
        }

        return filename;
    }

    private String formatFilename(String filename) {
        return filename.replaceAll("\\s+", "_");
    }

    public void deleteFile(String filename) throws IOException {
        Path path = Paths.get(folder, filename);
        Files.delete(path);
    }

    public String getStorageFolderPath(){
        return folder;
    }
}
