package com.example.sample.controller;

import com.example.sample.Mapper.CardMapper;
import com.example.sample.dto.CardDto;
import com.example.sample.entity.Card;
import com.example.sample.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardContoreller {
    private final CardService cardService;

    public CardContoreller(CardService cardService) {
        this.cardService = cardService;
    }
    @GetMapping("/cards")
    public List<CardDto> findAll(){
        return CardMapper.cardToCardDto(cardService.findAll());
    }
    @GetMapping("/card")
    public List<CardDto> findByCardNumber(@RequestParam("CARDNUMBER") String cardNumber){
return CardMapper.cardToCardDto(cardService.findByCardNumber(cardNumber));
    }
    @PostMapping("/card/")
    public void save(@RequestBody CardDto cardDto){
        cardService.save(CardMapper.toEntity(cardDto));
    }
}