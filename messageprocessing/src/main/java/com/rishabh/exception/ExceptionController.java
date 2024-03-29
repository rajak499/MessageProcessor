package com.rishabh.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
   @ExceptionHandler(value = Exception.class)
   public ResponseEntity<Object> exception(Exception exception) {
      return new ResponseEntity<>("Transaction not found", HttpStatus.NOT_FOUND);
   }
}