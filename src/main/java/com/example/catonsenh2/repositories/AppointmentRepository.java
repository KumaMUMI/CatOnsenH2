package com.example.catonsenh2.repositories;

import com.example.catonsenh2.models.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentModel,Long> {

    @Override
    Optional<AppointmentModel> findById(Long aLong);

    List<AppointmentModel> findAppointmentByDate(Date date);
}
