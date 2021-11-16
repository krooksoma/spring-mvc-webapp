package com.defaria.springmvcwebapp.controllers;

import com.defaria.springmvcwebapp.beans.Login;
import com.defaria.springmvcwebapp.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class DefaultModelAttributeController {

    @ModelAttribute("newuser")
    public User getDefaultUser(){
        return new User();
    }

    @ModelAttribute("genderItems")
    public List<String> genderGenderItems(){
        return Arrays.asList("Male", "Female", "Non-binary", "Other");}

    @ModelAttribute("login")
    public Login getDefaultLogin(){
        return new Login();
    }
}
