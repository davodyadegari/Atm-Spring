package com.example.sample.service;

import com.example.sample.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account login(String cardNumber, String password);

    void save(Account account);

    List<Account> findAll();

//    Optional<Account> findById(Integer id);
//
//    void delet(Account account);


//    List<Account> getAccounts();
}