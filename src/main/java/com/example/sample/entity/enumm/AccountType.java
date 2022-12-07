package com.example.sample.entity.enumm;

import java.util.stream.Stream;

public enum AccountType {
    SEPORDE(2),JARI(1),GHARZOL_HASANE(3);

    private Integer value;

    AccountType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static AccountType of(int priority) {
        return Stream.of(AccountType.values())
                .filter(p -> p.getValue() == priority)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
