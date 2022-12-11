package com.example.sample.entity.enumm;

import java.util.stream.Stream;

public enum TransactionType {
    DEPOSIT(2),WITHDRAW(1);

    private Integer value;

    TransactionType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
    public static TransactionType of(int priority) {
        return Stream.of(TransactionType.values())
                .filter(p -> p.getValue() == priority)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}