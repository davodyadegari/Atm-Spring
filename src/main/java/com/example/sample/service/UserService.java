package com.example.sample.service;

import com.example.sample.entity.User;

import java.time.LocalDate;

public interface UserService {
    User createUser(String name, String family, String nationalCode, LocalDate birthDay);

    User findAccountByNationalCode(String nationalCode);

    void save(User user);
}