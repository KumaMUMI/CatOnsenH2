package com.example.catonsenh2.service;

import com.example.catonsenh2.models.OnsenAppointModel;
import com.example.catonsenh2.repositories.OnsenAppointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OnsenAppointService {

    @Autowired
    private OnsenAppointRepository onsenAppointRepository;

    public OnsenAppointService(OnsenAppointRepository onsenAppointRepository) {
        this.onsenAppointRepository = onsenAppointRepository;
    }

    public List<OnsenAppointModel> findAllOnsenAppoint(){
        return this.onsenAppointRepository.findAll();
    }

    public Optional<OnsenAppointModel> findOnsenAppointByID(Long id){
        return this.onsenAppointRepository.findById(id);
    }

    public List<OnsenAppointModel> findByDate(Date date){
        List<OnsenAppointModel> appointDate = onsenAppointRepository.findOnsenAppointByDate(date);

        return appointDate;
    }

    public OnsenAppointModel saveOnsenAppoint(OnsenAppointModel appointment){
        return this.onsenAppointRepository.save(appointment);
    }

    public Optional<OnsenAppointModel> updateOnsenAppoint(Long id, OnsenAppointModel newAppointment){
        return this.onsenAppointRepository.findById(id).map(appointment -> {
            appointment.setRoom(newAppointment.getRoom());
            appointment.setPayment(newAppointment.getPayment());
            appointment.setDate(newAppointment.getDate());
            return onsenAppointRepository.save(appointment);
        });
    }

    public void deleteByID(Long id){
        this.onsenAppointRepository.deleteById(id);
    }
}
