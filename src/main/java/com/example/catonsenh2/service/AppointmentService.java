//package com.example.catonsenh2.service;
//
//import com.example.catonsenh2.models.AppointmentModel;
//import com.example.catonsenh2.repositories.AppointmentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AppointmentService {
//
//    @Autowired
//    private AppointmentRepository appointmentRepository;
//
//    public AppointmentService(AppointmentRepository appointmentRepository) {
//        this.appointmentRepository = appointmentRepository;
//    }
//
//    public List<AppointmentModel> findAlAppointment(){
//        return this.appointmentRepository.findAll();
//    }
//
//    public Optional<AppointmentModel> findAppointmentByID(Long id){
//        return this.appointmentRepository.findById(id);
//    }
//
//    public AppointmentModel saveAppointment(AppointmentModel appointment){
//        return this.appointmentRepository.save(appointment);
//    }
//
//    public Optional<AppointmentModel> updateAppointment(Long id,AppointmentModel newAppointment){
//        return this.appointmentRepository.findById(id).map(appointment -> {
//            appointment.setRoom(newAppointment.getRoom());
//            appointment.setPayment(newAppointment.getPayment());
//            appointment.setDate(newAppointment.getDate());
//            return appointmentRepository.save(appointment);
//        });
//    }
//
//    public void deleteByID(Long id){
//        this.appointmentRepository.deleteById(id);
//    }
//}
