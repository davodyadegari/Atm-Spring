package com.example.sample.Mapper;

import com.example.sample.dto.AccountDto;
import com.example.sample.entity.Account;
import com.example.sample.entity.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountMapper {
    public static List<AccountDto> accountToAccountDto(List<Account> accounts){
        List<AccountDto>accountDtos=new ArrayList<>();
        accounts.stream().forEach(a->{accountDtos.add(new AccountDto(a.getUser(),a.getPassword(),a.getAccountNumber(),a.getBalance(),a.getAccountType()
        ,a.getTransactions()));
        });
        return accountDtos;
    }
    public static Optional<AccountDto> accountToAccountDto(Optional<Account>account){
        Optional<AccountDto>optionalAccountDto=Optional.of(new AccountDto(account.get().getUser(),account.get().getAccountNumber()
        ,account.get().getPassword(),account.get().getBalance(),account.get().getAccountType(),account.get().getTransactions()));
        return optionalAccountDto;
    }
    public static Account toEntity(AccountDto accountDto){
        Account account=new Account(accountDto.getUser(),new Card(accountDto.getPassword()),accountDto.getPassword(),accountDto.getAccountType(),new Integer(3));
        return account;
    }
}