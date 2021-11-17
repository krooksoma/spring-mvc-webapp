package com.defaria.springmvcwebapp.controllers;

import com.defaria.springmvcwebapp.beans.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserProfileController {

    @PostMapping("/userprofile")
    public String getUserProfile(@SessionAttribute("login") Login login, Model model){
        System.out.println("In User profile Controller");
        System.out.println("Username from session: " + login.getUserName());
        model.addAttribute("username", login.getUserName());
        return "profile";
    }
}
