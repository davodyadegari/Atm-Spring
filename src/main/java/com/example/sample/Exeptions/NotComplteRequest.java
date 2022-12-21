package com.example.sample.Exeptions;

import org.springframework.http.HttpStatus;

public class NotComplteRequest extends BaseException {
private final static String MESSAGE="nationalCode is null !!!";
    public NotComplteRequest() {
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