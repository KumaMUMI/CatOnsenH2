package com.example.catonsenh2.repositories;

import com.example.catonsenh2.models.MassageAppointModel;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MassageAppointRepository extends JpaRepository<MassageAppointModel , Long> {

    @Override
    Optional<MassageAppointModel> findById(Long aLong);

    List<MassageAppointModel> findMassageAppointByDate(Date date);
}
