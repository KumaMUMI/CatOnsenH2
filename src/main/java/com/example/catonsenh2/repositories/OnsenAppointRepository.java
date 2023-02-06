package com.example.catonsenh2.repositories;

import com.example.catonsenh2.models.OnsenAppointModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OnsenAppointRepository extends JpaRepository<OnsenAppointModel,Long> {

    @Override
    Optional<OnsenAppointModel> findById(Long aLong);

    List<OnsenAppointModel> findOnsenAppointByDate(Date date);
}
