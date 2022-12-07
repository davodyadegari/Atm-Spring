package com.example.sample.service.impl;

import com.example.sample.entity.Account;
import com.example.sample.repository.AccountRepository;
import com.example.sample.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public void save(Account account){
        accountRepository.save(account);
    }
    @Override
    public List<Account> findAll(){
        return accountRepository.findAll();
    }
    //    List<Account> accounts;
//
//    public AccountServiceImpl() {
//        this.accounts = new ArrayList<>();
//    }
//@Override
//    public void save(Account account) {
//        this.accounts.add(account);
//    }
//@Override
//    public List<Account> getAccounts() {
//        return accounts;
//    }
}