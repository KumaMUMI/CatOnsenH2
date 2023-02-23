package com.example.catonsenh2.repositories;

import com.example.catonsenh2.models.MassageImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MassageImageRepository extends JpaRepository<MassageImageModel,Long> {
    @Override
    Optional<MassageImageModel> findById(Long id);
}
