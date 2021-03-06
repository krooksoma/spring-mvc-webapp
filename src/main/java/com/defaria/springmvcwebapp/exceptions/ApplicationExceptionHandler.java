package com.defaria.springmvcwebapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//apply this advice at exception handling to all the controllers of the application

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public String handleException(){
        System.out.println("In global Exception handler");
        return "error";
    }

    @ExceptionHandler(LoginFailedException.class)
    public ResponseEntity handleLoginFailure(LoginFailedException lfex){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(lfex.getMessage());
    }

}
