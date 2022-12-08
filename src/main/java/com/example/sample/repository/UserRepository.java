package com.example.sample.repository;

import com.example.sample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>findByNationalCode(String nationalCode);
}