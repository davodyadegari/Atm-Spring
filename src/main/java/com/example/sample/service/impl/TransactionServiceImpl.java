package com.example.sample.service.impl;

import com.example.sample.entity.Transaction;
import com.example.sample.repository.TransactionRepository;
import com.example.sample.service.TransactionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Override
    public void save(Transaction transaction){
        transactionRepository.save(transaction);
    }
    @Override
    public List<Transaction> lastTenTransactions(String cardNumber) {

        return transactionRepository.findByAccount_Card_CardNumberOrderByDate(cardNumber, PageRequest.of(0,10)).getContent();
    }
}