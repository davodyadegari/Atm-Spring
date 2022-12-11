package com.example.sample.service;

import com.example.sample.entity.Transaction;

import java.util.List;

public interface TransactionService {
    void save(Transaction transaction);


    List<Transaction> lastTenTransactions(String cardNumber);
}