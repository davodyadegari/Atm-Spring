package com.example.sample.Mapper;

import com.example.sample.dto.CardDto;
import com.example.sample.entity.Card;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapStruct {
    Card toCard(CardDto cardDto);
    CardDto toCardDto(Card card);
    List<CardDto> toCardDto(List<Card>cards);
    List<Card> toCard(List<CardDto> cardDtos);
}