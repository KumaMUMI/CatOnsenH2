package com.example.catonsenh2.repositories;

import com.example.catonsenh2.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel , Long> {
}
