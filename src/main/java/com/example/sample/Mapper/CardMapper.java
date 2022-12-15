package com.example.sample.Mapper;

import com.example.sample.dto.CardDto;
import com.example.sample.entity.Card;

import java.util.ArrayList;
import java.util.List;

public class CardMapper {
    public static List<CardDto> cardToCardDto(List<Card>cards){
        List<CardDto>cardDtos=new ArrayList<>();
        cards.forEach(c->{
            cardDtos.add(new CardDto(c.getCardNumber(), c.getCvv2(),c.getExpiredDate()));
        }
        );
        return cardDtos;
    }
    public static Card toEntity(CardDto cardDto){
    return new Card(null,cardDto.getCardNumber(),cardDto.getCvv2(),cardDto.getExpiredDate(),"25234");
    }
}