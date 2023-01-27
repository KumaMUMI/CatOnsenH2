package com.example.catonsenh2.repositories;

import com.example.catonsenh2.models.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentModel,Long> {
}
