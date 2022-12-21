package com.example.sample.Exeptions;

import org.springframework.http.HttpStatus;

public class InvalidInputException extends BaseException {
    private final static String MESSAGE="User already exist";
    public InvalidInputException() {
        super(MESSAGE);
    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }

    @Override
    protected HttpStatus httpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
