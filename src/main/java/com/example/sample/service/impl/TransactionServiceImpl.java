package com.example.sample.service.impl;

import com.example.sample.entity.Transaction;
import com.example.sample.repository.TransactionRepository;
import com.example.sample.service.TransactionService;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Override
    public void save(Transaction transaction){
        transactionRepository.save(transaction);
    }
}