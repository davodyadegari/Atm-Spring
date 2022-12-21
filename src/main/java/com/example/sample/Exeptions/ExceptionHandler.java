package com.example.sample.Exeptions;

import com.example.sample.dto.ResponseDto;
import com.example.sample.util.MyMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.http.HttpRequest;
import java.sql.SQLException;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = BaseException.class)
    public static ResponseEntity<ResponseDto> handleRuntimeException(BaseException exception){
        ResponseEntity<ResponseDto> responseEntity=new ResponseEntity<>(new ResponseDto()
                .setMessage(exception.getMessage())
                .setLocalDateTime(LocalDateTime.now())
                .setStatus(exception.httpStatus().value()),exception.httpStatus() );
        return responseEntity;
//        if (exception instanceof SQLException) {
//            SQLException sqlException = (SQLException) exception;
//
////you can search the error code by googling Dunning mysql error code
//            MyMethod.print("Error code:" + sqlException.getErrorCode());
//
//            MyMethod.print("SQL state:" + sqlException.getSQLState());
//        }
//        MyMethod.print("Exception message:" + exception.getMessage());
//        MyMethod.print("Stacktrace:");
//        exception.printStackTrace();
        }
    }
