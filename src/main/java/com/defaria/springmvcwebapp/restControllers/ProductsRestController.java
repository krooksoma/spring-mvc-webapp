package com.defaria.springmvcwebapp.restControllers;

import com.defaria.springmvcwebapp.beans.Product;
import com.defaria.springmvcwebapp.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsRestController {

    private ProductRepository productRepository;


//    @GetMapping("/hplus/rest/products")
//    public List<Product> getProducts(){
//        List<Product> products = new ArrayList<>();
////        productRepository.findAll().forEach(product -> products.add(product));
//        productRepository.findAll().forEach(products::add);
//        return products;
//    }

    @GetMapping("/hplus/rest/products")
    public ResponseEntity getProductsByRequestParam(@RequestParam("name") String name){
        List<Product> products = productRepository.searchByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/hplus/rest/products/{name}")
    public ResponseEntity getProductsByPathVariable(@PathVariable("name") String name){
        List<Product> products = productRepository.searchByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

