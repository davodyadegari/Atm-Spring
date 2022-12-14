package com.example.sample.service;

import com.example.sample.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByNationalCode(String nationalCode);

    User createUser(Long id, String name, String family, String nationalCode, LocalDate birthDay);

    User findAccountByNationalCode(String nationalCode);

    void save(User user);
    List<User> findAll();
}