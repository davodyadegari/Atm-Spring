package com.example.sample.controller;

import com.example.sample.Mapper.AccountMapper;
import com.example.sample.dto.AccountDto;
import com.example.sample.entity.Account;
import com.example.sample.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/accounts")
    public List<AccountDto>findAll(){
        return AccountMapper.accountToAccountDto(accountService.findAll());
    }
    @GetMapping("/account")
    public Optional<AccountDto>findByUser_NationalCode(@RequestParam("NATIONAL_CODE")@Valid String nationalCode){
        return AccountMapper.accountToAccountDto(accountService.findByUser_NationalCode(nationalCode));
    }
    @PostMapping("/account/")
    public void save(@Valid AccountDto accountDto){
        accountService.save(AccountMapper.toEntity(accountDto));
    }
}