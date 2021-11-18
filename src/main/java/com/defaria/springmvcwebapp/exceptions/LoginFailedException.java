package com.defaria.springmvcwebapp.exceptions;

public class LoginFailedException extends Exception{

    public LoginFailedException(String message){
        super(message);
    }
}
