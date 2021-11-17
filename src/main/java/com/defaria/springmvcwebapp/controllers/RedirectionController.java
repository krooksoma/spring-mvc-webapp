package com.defaria.springmvcwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectionController {

    @GetMapping("/redirecttolinkedin")
    public String redirect(){
        System.out.println("Inside redirect controller");
        return "redirect:http://www.linkedin.com";
    }
}
