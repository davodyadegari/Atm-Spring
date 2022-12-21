package com.example.sample.dto;

import com.example.sample.Exeptions.InvalidAmountException;
import com.example.sample.entity.Card;
import com.example.sample.entity.Transaction;
import com.example.sample.entity.User;
import com.example.sample.entity.enumm.AccountType;
import com.example.sample.entity.enumm.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountDto {
//    private Integer id;

//    private final static Double MIN_BALANCE = 100d;
//    @NotNull
//    private CardDto cardDto;
    @NotNull
    private UserDto userDto;
    @NotNull
    @NotBlank
    private String accountNumber;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    private Double balance;
    @NotNull
    private AccountType accountType;

    private List<Transaction> transactions;

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

}