package com.example.catonsenh2.controller;

import com.example.catonsenh2.models.OnsenAppointModel;
import com.example.catonsenh2.service.OnsenAppointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/onsen")
@CrossOrigin("*")
public class OnsenAppointController {

    @Autowired
    private final OnsenAppointService onsenAppointService;

    public OnsenAppointController(OnsenAppointService onsenAppointService) {
        this.onsenAppointService = onsenAppointService;
    }

    @GetMapping("/{sDate}")
    public @ResponseBody ResponseEntity<List<OnsenAppointModel>> getOnsenAppointByDate(@PathVariable String sDate){
        Instant iDate = Instant.parse(sDate);
        Date date = Date.from(iDate);
        return new ResponseEntity<>(this.onsenAppointService.findByDate(date), HttpStatus.OK);
    }

    @GetMapping("")
    public @ResponseBody ResponseEntity<List<OnsenAppointModel>> getAllOnsenAppoint(){
        return new ResponseEntity<>(this.onsenAppointService.findAllOnsenAppoint(),HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody ResponseEntity<OnsenAppointModel> postOnsenAppoint(@RequestBody OnsenAppointModel onsenAppoint){
        return new ResponseEntity<>(this.onsenAppointService.saveOnsenAppoint(onsenAppoint),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteUser(@PathVariable Long id){
        this.onsenAppointService.deleteByID(id);
        return new ResponseEntity<>(String.format("%d has deleted.",id),HttpStatus.OK);
    }
}
