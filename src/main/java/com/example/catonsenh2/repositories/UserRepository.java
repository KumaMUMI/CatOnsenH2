package com.example.catonsenh2.repositories;

import com.example.catonsenh2.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel , Long> {

    @Override
    Optional<UserModel> findById(Long aLong);

    List<UserModel> findByEmailAndTel(String email,String tel);

    List<UserModel> findByName(String name);

    List<UserModel> findByTel(String tel);

    List<UserModel> findByEmail(String email);
}
