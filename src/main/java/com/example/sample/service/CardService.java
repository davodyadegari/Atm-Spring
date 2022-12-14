package com.example.sample.service;

import com.example.sample.entity.Card;

import java.util.List;

public interface CardService {
    void save(Card card);

    List<Card> findByCardNumber(String cardNumber);

    List<Card>findAll();
}