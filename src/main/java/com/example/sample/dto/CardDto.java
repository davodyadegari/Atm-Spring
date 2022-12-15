package com.example.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private String cardNumber;
    private String cvv2;
    private LocalDate expiredDate;
//    private String password;
//
//    public String getCardNumber() {
//        return cardNumber;
//    }
//
//    public boolean validation(String pass){
//        return pass.equals(this.password);
//    }
}