package com.defaria.springmvcwebapp.controllers;

import com.defaria.springmvcwebapp.beans.Login;
import com.defaria.springmvcwebapp.beans.User;
import com.defaria.springmvcwebapp.exceptions.ApplicationException;
import com.defaria.springmvcwebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

//when using sessionAttributes you must make sure the same name already exists inside the controller
@Controller
@SessionAttributes("login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;



    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login){
        User user = userRepository.searchByName(login.getUserName());
        if(user == null){
            throw new ApplicationException("User not Found");
        }
        return "profile";
    }
//    once exception is thrown it will come inside handleException method, and it will go to error page
//    @ExceptionHandler(ApplicationException.class)
//    public String handleException(){
//        System.out.println("In Exception Handler of Login Controller");
//        return "error";
//    }

}
