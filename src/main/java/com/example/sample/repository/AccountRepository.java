package com.example.sample.repository;

import com.example.sample.entity.Account;
import com.example.sample.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
   Optional<Account>findByCard_CardNumber(String cardNumber);
   Optional<Account>findByUser_NationalCode(String nationalCode);
   List<Account>findAll();

}