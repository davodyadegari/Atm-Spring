package com.example.sample.repository;

import com.example.sample.dto.UserDto;
import com.example.sample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
   Optional<User>findByNationalCode(String nationalCode);
    void deleteByName(String name);
    Optional<User> findById(Long id);
    User save(UserDto userDto);
}