package com.example.sample.service.impl;

import com.example.sample.entity.Card;
import com.example.sample.repository.CardRepository;
import com.example.sample.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
    @Override
    public void save(Card card){
        cardRepository.save(card);
    }
    @Override
    public List<Card> findByCardNumber(String cardNumber){
        return cardRepository.findByCardNumber(cardNumber);
    }
    @Override
    public List<Card>findAll(){
        return cardRepository.findAll();
    }
}