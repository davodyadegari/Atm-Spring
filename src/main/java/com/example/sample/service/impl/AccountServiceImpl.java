package com.example.sample.service.impl;

import com.example.sample.Exeptions.InvalidPasswordException;
import com.example.sample.Exeptions.NotFoundException;
import com.example.sample.entity.Account;
import com.example.sample.entity.Card;
import com.example.sample.entity.User;
import com.example.sample.entity.enumm.AccountType;
import com.example.sample.repository.AccountRepository;
import com.example.sample.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public Account login(String cardNumber, String password) {
        Account account = this.accountRepository.findByCard_CardNumber(cardNumber).orElseThrow(() -> {
            throw new NotFoundException("account not found");
        });
        if (account.getCard().validation(password))
            return account;
        else
            throw new InvalidPasswordException();
    }
    @Override
    public void save(Account account){
        accountRepository.save(account);
    }
    @Override
    public List<Account> findAll(){
        return accountRepository.findAll();
    }
    public Account createAccount(User user, Card card, String password, Integer accountTypeValue) {
        AccountType accountType = AccountType.of(accountTypeValue);
        Account account = new Account(user,card, password, accountType,accountTypeValue);
        accountRepository.save(account);
        return account;
    }
    @Override
public Optional<Account>findByUser_NationalCode(String nationalCode){
        return accountRepository.findByUser_NationalCode(nationalCode);
    }
    public void moneyTransfer(String cardNum1, String cardNum2, double amount) {
        accountRepository.findByCard_CardNumber(cardNum1).ifPresentOrElse(account -> {
            Account account2 = accountRepository.findByCard_CardNumber(cardNum2).orElseThrow();
            account.withDraw(amount);
            account2.deposit(amount);
        }, () -> {
            throw new NotFoundException("no account by this card number");
        });

    }
//    @Override
//    public Optional<Account> findById(Integer id){
//      return accountRepository.findById(2l);
//        }
//    @Override
//    public void delet(Account account){
//        accountRepository.delete(account);
//    }
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