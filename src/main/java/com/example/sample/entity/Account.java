package com.example.sample.entity;

import com.example.sample.Exeptions.InvalidAmountException;
import com.example.sample.entity.enumm.AccountType;
import com.example.sample.entity.enumm.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "account_number",unique = true,nullable = false,length =20)
    private String accountNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    @Column(name = "password",nullable = false,length = 20)
    private String password;
    @Column(name = "balance",length = 30)
    private Double balance;
    @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "card_id")
    private Card card;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "account")
    private List<Transaction>transactions;
//    @Column(nullable = false,name = "account_type")
//    @Enumerated(value = EnumType.STRING)
//    private AccountType accountType;
    @Basic
    @Column(name = "account_type_value",nullable = false)
    private Integer accountTypeValue;
    @Transient
    @Column(nullable = false,name = "account_type")
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
    public Account(User user, String password, AccountType accountType,Integer accountTypeValue) {
        Random random = new Random();
        this.id= random.nextLong();
        this.user = user;
        this.accountNumber = String.valueOf(random.nextLong(10000000,999999999));
        this.password = password;
       this.balance = 300d;
        this.accountType = accountType;
        this.card = new Card(password);
        this.accountTypeValue=accountTypeValue;
    }

    public void deposit(Double amount) {
        this.balance += amount;
        Transaction transaction = new Transaction(amount, TransactionType.DEPOSIT);
        if (Objects.isNull(transactions))
            transactions = new ArrayList<>();
        transactions.add(transaction);
    }

    public void withDraw(Double amount) {
        if (amount < this.balance) {
            this.balance = this.balance - amount;
            Transaction transaction = new Transaction(amount, TransactionType.WITHDRAW);
            if (Objects.isNull(transactions))
                transactions = new ArrayList<>();
            transactions.add(transaction);
        } else
            throw new InvalidAmountException();
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", user=" + user +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", card=" + card +
                ", accountType=" + accountType +
                '}';
    }
}