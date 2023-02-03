package com.example.catonsenh2.controller;

import com.example.catonsenh2.models.AppointmentModel;
import com.example.catonsenh2.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/appoint")
@CrossOrigin("*")
public class AppointController {

    @Autowired
    private final AppointmentService appointmentService;

    public AppointController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{sDate}")
    public @ResponseBody ResponseEntity<List<AppointmentModel>> getAppointByDate(@PathVariable String sDate) throws ParseException {
        Instant iDate = Instant.parse(sDate);
        Date date = Date.from(iDate);
        return new ResponseEntity<>(this.appointmentService.findByDate(date), HttpStatus.OK);
    }
}
