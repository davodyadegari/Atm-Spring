package com.example.sample.repository;

import com.example.sample.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    Page<Transaction>findByAccount_Card_CardNumberOrderByDate(String cardNumber, Pageable pageable);
}