package com.example.catonsenh2.controller;

import com.example.catonsenh2.models.MassageAppointModel;
import com.example.catonsenh2.service.MassageAppointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/massage")
@CrossOrigin("*")
public class MassageAppointController {

    @Autowired
    private final MassageAppointService massageAppointService;

    public MassageAppointController(MassageAppointService massageAppointService) {
        this.massageAppointService = massageAppointService;
    }
    @GetMapping("/{sDate}")
    public @ResponseBody ResponseEntity<List<MassageAppointModel>> getMassageAppointNyDate(@PathVariable String sDate){
        Instant iDate = Instant.parse(sDate);
        Date date = Date.from(iDate);
        return new ResponseEntity<>(this.massageAppointService.findByDate(date), HttpStatus.OK);
    }

    @GetMapping("")
    public @ResponseBody ResponseEntity<List<MassageAppointModel>> getAllMassageAppoint(){
        return new ResponseEntity<>(this.massageAppointService.findAllMassageAppoint(),HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody ResponseEntity<MassageAppointModel> postMassageAppoint(@RequestBody MassageAppointModel massageAppoint){
        return new ResponseEntity<>(this.massageAppointService.saveMassageAppoint(massageAppoint),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteUser(@PathVariable Long id){
        this.massageAppointService.deleteByID(id);
        return new ResponseEntity<>(String.format("%d has deleted.",id),HttpStatus.OK);
    }
}
