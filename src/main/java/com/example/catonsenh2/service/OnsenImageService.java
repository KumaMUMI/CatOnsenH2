package com.example.catonsenh2.service;

import com.example.catonsenh2.models.MassageImageModel;
import com.example.catonsenh2.models.OnsenImageModel;
import com.example.catonsenh2.repositories.OnsenImageRepository;
import com.example.catonsenh2.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class OnsenImageService {

    @Autowired
    private OnsenImageRepository onsenImageRepository;

    public String uploadOnsenImage(MultipartFile file) throws IOException {
        OnsenImageModel imageData = onsenImageRepository.save(OnsenImageModel.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return String.format("%s",imageData.getName());
        }
        return null;
    }
    public byte[] downloadOnsenImage(Long id) {
        Optional<OnsenImageModel> dbImageData = onsenImageRepository.findById(id);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }

    public void deleteByID(Long id){
        this.onsenImageRepository.deleteById(id);
    }
}
