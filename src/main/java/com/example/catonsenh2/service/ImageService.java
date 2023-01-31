package com.example.catonsenh2.service;

import com.example.catonsenh2.models.ImageModel;
import com.example.catonsenh2.repositories.ImageRepository;
import com.example.catonsenh2.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public String uploadImage(MultipartFile file) throws IOException {
        ImageModel imageData = imageRepository.save(ImageModel.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return String.format("http://localhost:8080/image/%s",imageData.getName());
        }
        return null;
    }

    public byte[] downloadImage(String fileName) {
        Optional<ImageModel> dbImageData = imageRepository.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
