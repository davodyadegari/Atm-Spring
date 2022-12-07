package com.example.sample.entity;

import com.example.sample.entity.enumm.AccountType;
import com.example.sample.entity.enumm.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long id;
    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Basic
    @Column(nullable = false)
    private Integer transactionTypeValue;
    @Transient
    @Column(nullable = false)
    private TransactionType transactionType;

    @PostLoad
    void fillTransient() {
        if (transactionTypeValue != null) {
            this.transactionType = TransactionType.of(transactionTypeValue);
        }
    }

    @PrePersist
    void fillPersistent() {
        if (transactionType != null) {
            this.transactionTypeValue = transactionType.getValue();
        }
    }

    public Transaction(Long id, Double amount, Date date, Integer transactionTypeValue, TransactionType transactionType) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.transactionTypeValue = transactionTypeValue;
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", transactionTypeValue=" + transactionTypeValue +
                ", transactionType=" + transactionType +
                '}';
    }
}