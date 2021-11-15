package com.defaria.springmvcwebapp.controllers;

import com.defaria.springmvcwebapp.beans.User;
import com.defaria.springmvcwebapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;


    @InitBinder
    public void initBinder(WebDataBinder binder){
//      converts data type to the String value you want it to be converted. Custom[...]editor comes from spring property editors
        binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true) );
    }
//    to register user information you need to use postMapping
    @PostMapping("/registeruser")
    @ResponseStatus(HttpStatus.OK)
//   @Valid letting the application know that JSR-380 validation is being used in the Bean
//    BindingResult parameter will be used to populate an error in case of validation failure(binding)
//    must follow @modelAttribute
    public String registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, Model model){
        System.out.println("inside user registration controller");

        if(result.hasErrors()){
        model.addAttribute("dataError", "Invalid Values passed. Try Again");
            return "register";
        }

        userRepository.save(user);
//        allows message to be sent to the UI confirming that the data was saved
        model.addAttribute("dataSaved", "User registered successfully");
        return "login";
    }
}
