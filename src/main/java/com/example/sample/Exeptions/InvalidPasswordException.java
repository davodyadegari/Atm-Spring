package com.example.sample.Exeptions;

import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends BaseException{
    public static final String Message = "Wrong Password!";
    public InvalidPasswordException() {
        super(Message);
    }

    @Override
    public String getMessage() {
        return Message;
    }

    @Override
    protected HttpStatus httpStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
