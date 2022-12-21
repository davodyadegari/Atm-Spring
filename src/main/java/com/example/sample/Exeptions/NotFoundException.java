package com.example.sample.Exeptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {
   private final static String MESSAGE="NOT FOUND";

   public NotFoundException() {
      super(MESSAGE);
   }

   @Override
   public String getMessage() {
      return MESSAGE;
   }

   @Override
   protected HttpStatus httpStatus() {
      return HttpStatus.NO_CONTENT;
   }
}
