package com.example.sample.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "cards")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "card_number",unique = true,nullable = false,length = 16)
    private String cardNumber;
    @Column(nullable = false,length = 4,unique = true)
    private String cvv2;
    @Column(name = "expired_date",nullable = false)
    private LocalDate expiredDate;
    @Column(nullable = false,length = 4,unique = true)
    private String password;
//    @OneToOne(mappedBy = "card",fetch = FetchType.EAGER)
//    private Account account;
//
//    public Card(Long id, String cardNumber, String cvv2, LocalDate expiredDate, String password) {
//        this.id = id;
//        this.cardNumber = cardNumber;
//        this.cvv2 = cvv2;
//        this.expiredDate = expiredDate;
//        this.password = password;
//    }

//    @Override
//    public String toString() {
//        return "Card{" +
//                "id=" + id +
//                ", cardNumber='" + cardNumber + '\'' +
//                ", cvv2='" + cvv2 + '\'' +
//                ", expiredDate=" + expiredDate +
//                ", password='" + password + '\'' +
//                '}';
//    }
}