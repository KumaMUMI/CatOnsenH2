package com.example.catonsenh2.controller;

import com.example.catonsenh2.service.OnsenImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin("*")
@RequestMapping("/onsen/image")
public class OnsenImageController {

    @Autowired
    private OnsenImageService onsenImageService;

    @GetMapping("/{id}")
    public ResponseEntity<?> downloadImage(@PathVariable Long id) {
        byte[] imageData = onsenImageService.downloadOnsenImage(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
    @PostMapping("")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = onsenImageService.uploadOnsenImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }
}
