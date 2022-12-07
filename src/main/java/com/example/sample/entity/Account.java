package com.example.sample.entity;

import com.example.sample.entity.enumm.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "account_number",unique = true,nullable = false,length = 16)
    private String accountNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    @Column(name = "password",nullable = false,length = 20,unique = true)
    private String password;
    @Column(name = "balance",length = 30,nullable = false)
    private Double balance;
    @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "card_id",nullable = false)
    private Card card;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Transaction>transactions;
    @Basic
    @Column(nullable = false)
    private Integer accountTypeValue;
    @Transient
    @Column(nullable = false)
    private AccountType accountType;
    @PostLoad
    void fillTransient() {
        if (accountTypeValue !=null) {
            this.accountType = AccountType.of(accountTypeValue);
        }
    }

    @PrePersist
    void fillPersistent() {
        if (accountType != null) {
            this.accountTypeValue = accountType.getValue();
        }
    }


//    public Account(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    public String getAccountNumber() {
//        return accountNumber;
//    }
//
//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    @Override
//    public String toString() {
//        return "Account{" +
//                "accountNumber='" + accountNumber + '\'' +
//                '}';
//    }
}