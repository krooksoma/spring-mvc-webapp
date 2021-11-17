package com.defaria.springmvcwebapp.controllers;

import com.defaria.springmvcwebapp.beans.Product;
import com.defaria.springmvcwebapp.repository.ProductRepository;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;



@Controller
public class SearchController {

//    make sure repository DI is deposited in this controller

    private ProductRepository productRepository;


    private AsyncTaskExecutor executor;

    @GetMapping("/search")
//    the parameter for RequestParam must match the same in the jsp/html file
    public DeferredResult<String> search(@RequestParam("search") String search, Model model, HttpServletRequest request){

        DeferredResult<String> deferredResult = new DeferredResult<>();
        System.out.println("Inside Search Controller");
        System.out.println("Search criteria: " + search);
        System.out.println("Async Supported in Application " + request.isAsyncSupported());
//        from tomcat servlet container
        System.out.println("Thread from the servlet container: " + Thread.currentThread().getName());


//        return ()->{
//            Thread.sleep(3000);
//            System.out.println("Thread from spring mvc task executor: " + Thread.currentThread().getName());
//            List<Product> products = new ArrayList<>();
//            products = productRepository.searchByName(search);
//            model.addAttribute("products", products);
//            System.out.println(products);
//
//            return "search";
//        };

        executor.execute(()->{
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Thread from spring mvc task executor: " + Thread.currentThread().getName());
            List<Product> products;
            products = productRepository.searchByName(search);
            model.addAttribute("products", products);
            deferredResult.setResult("search");
        });

        return deferredResult;
    }



//    @GetMapping("/search")
//    public ModelAndView search(){
//        System.out.println("Inside Search Controller");
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject();
//    }
}
