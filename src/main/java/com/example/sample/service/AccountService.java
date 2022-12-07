package com.example.sample.service;

import com.example.sample.entity.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);

    List<Account> findAll();

//    List<Account> getAccounts();
}