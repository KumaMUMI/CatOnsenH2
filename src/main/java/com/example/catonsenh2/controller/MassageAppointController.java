package com.example.catonsenh2.controller;

import com.example.catonsenh2.models.MassageAppointModel;
import com.example.catonsenh2.service.MassageImageService;
import com.example.catonsenh2.service.MassageAppointService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/massage")
@CrossOrigin("*")
public class MassageAppointController {

    @Autowired
    private final MassageAppointService massageAppointService;

    @Autowired
    private MassageImageService massageImageService;

    @Autowired
    private ObjectMapper objectMapper;

    public MassageAppointController(MassageAppointService massageAppointService) {
        this.massageAppointService = massageAppointService;
    }
    @GetMapping("/date/{sDate}")
    public @ResponseBody ResponseEntity<List<MassageAppointModel>> getMassageAppointNyDate(@PathVariable String sDate){
        Instant iDate = Instant.parse(sDate);
        Date date = Date.from(iDate);
        return new ResponseEntity<>(this.massageAppointService.findByDate(date), HttpStatus.OK);
    }

    @GetMapping("")
    public @ResponseBody ResponseEntity<List<MassageAppointModel>> getAllMassageAppoint(){
        return new ResponseEntity<>(this.massageAppointService.findAllMassageAppoint(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Optional<MassageAppointModel>> getOneMassageAppoint(@PathVariable Long id){
        return new ResponseEntity<>(this.massageAppointService.findMassageAppointByID(id),HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody ResponseEntity<MassageAppointModel> postMassageAppoint(@RequestParam("image") MultipartFile file, @RequestPart("massage") String massageAppointJson) throws IOException {
        try {
            MassageAppointModel massage = objectMapper.readValue(massageAppointJson, MassageAppointModel.class);
            String image = this.massageImageService.uploadMassageImage(file);
            massage.setMassImage(image);
            return new ResponseEntity<>(this.massageAppointService.saveMassageAppoint(massage),HttpStatus.CREATED);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Optional<MassageAppointModel>> putOnsenAppoint(@PathVariable Long id ,@RequestBody MassageAppointModel massageAppoint){
        return new ResponseEntity<>(this.massageAppointService.updateMassageAppoint(id,massageAppoint),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteUser(@PathVariable Long id){
        this.massageImageService.deleteByID(id);
        this.massageAppointService.deleteByID(id);
        return new ResponseEntity<>(String.format("%d has deleted.",id),HttpStatus.OK);
    }
}
