package com.defaria.springmvcwebapp.controllers;

import com.defaria.springmvcwebapp.beans.Product;
import com.defaria.springmvcwebapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SeachController {

//    make sure repository DI is deposited in this controller
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/search")
//    the parameter for RequestParam must match the same in the jsp/html file
    public String search(@RequestParam("search") String search, Model model){
        System.out.println("Inside Search Controller");
        System.out.println("Search criteria: " + search);

        List<Product> products = new ArrayList<>();
        products = productRepository.searchByName(search);
        model.addAttribute("products", products);
        System.out.println(products);

        return "search";
    }



//    @GetMapping("/search")
//    public ModelAndView search(){
//        System.out.println("Inside Search Controller");
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject();
//    }
}
