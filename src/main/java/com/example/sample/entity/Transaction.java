package com.example.sample.entity;

import com.example.sample.entity.enumm.AccountType;
import com.example.sample.entity.enumm.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false,name = "amount")
    private Double amount;

    @Column(name = "date")
    private LocalDate date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;
       @Column(nullable = false,name = "transaction_type")
       @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;
//    @Basic
//    @Column(name = "transaction_type_value",nullable = false)
//    private Integer transactionTypeValue;
//    @Transient
//    @Column(nullable = false,name = "transaction_type")
//    private TransactionType transactionType;
//
//    @PostLoad
//    void fillTransient() {
//        if (transactionTypeValue != null) {
//            this.transactionType = TransactionType.of(transactionTypeValue);
//        }
//    }
//
//    @PrePersist
//    void fillPersistent() {
//        if (transactionType != null) {
//            this.transactionTypeValue = transactionType.getValue();
//        }
//    }
@PrePersist
    public void beforePersist(){
        this.date=LocalDate.now();
    }
    public Transaction(Integer id,Double amount, TransactionType transactionType,Account account) {
        this.amount = amount;
        this.id=id;
        this.account=account;
        this.transactionType = transactionType;

    }
    public Transaction(Double amount, TransactionType transactionType) {
        this.account=account;
        this.transactionType = transactionType;

    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", account=" + account +
                ", transactionType=" + transactionType +
                '}';
    }
}