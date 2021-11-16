package com.defaria.springmvcwebapp.controllers;

import com.defaria.springmvcwebapp.beans.Login;
import com.defaria.springmvcwebapp.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String goHome(){
        System.out.println("in Home Controller");
        return "index";
    }

    @GetMapping("/gotosearch")
    public String goToSearch(){
        System.out.println("You are in gotosearch getmapping");
        return "search";
    }

    @GetMapping("/gotologin")
    public String gotoLogin(){
        System.out.println("Inside gotoLogin getmapping");
        return "login";
    }

    @GetMapping("/gotoregistration")
    public String goToRegistration(){
        System.out.println("Inside gotoRegister getmapping");
        return "register";
    }

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
