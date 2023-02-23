package com.example.catonsenh2.controller;

import com.example.catonsenh2.service.MassageImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/massage/image")
public class MassageImageController {

    @Autowired
    private MassageImageService massageImageService;

    @GetMapping("/{id}")
    public ResponseEntity<?> downloadImage(@PathVariable Long id) {
        byte[] imageData = massageImageService.downloadMassageImage(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
    @PostMapping("")
    public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
        String uploadImage = massageImageService.uploadMassageImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }
}
