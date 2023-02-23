package com.example.catonsenh2.service;

import com.example.catonsenh2.models.MassageImageModel;
import com.example.catonsenh2.repositories.MassageImageRepository;
import com.example.catonsenh2.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
@Service
public class MassageImageService {

    @Autowired
    private MassageImageRepository massageImageRepository;

    public String uploadMassageImage(MultipartFile file) throws IOException {
        MassageImageModel imageData = massageImageRepository.save(MassageImageModel.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return String.format("%s",imageData.getName());
        }
        return null;
    }
    public byte[] downloadMassageImage(Long id) {
        Optional<MassageImageModel> dbImageData = massageImageRepository.findById(id);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }

    public void deleteByID(Long id){
        this.massageImageRepository.deleteById(id);
    }
}
