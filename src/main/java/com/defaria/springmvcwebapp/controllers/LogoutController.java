package com.defaria.springmvcwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpSession session){
        System.out.println("Inside Logout Controller");
        session.invalidate();
        return "login";
    }
}
