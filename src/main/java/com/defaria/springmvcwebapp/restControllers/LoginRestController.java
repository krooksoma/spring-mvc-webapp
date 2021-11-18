package com.defaria.springmvcwebapp.restControllers;


import com.defaria.springmvcwebapp.beans.Login;
import com.defaria.springmvcwebapp.beans.User;
import com.defaria.springmvcwebapp.exceptions.LoginFailedException;
import com.defaria.springmvcwebapp.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {
    private UserRepository userRepository;

    @PostMapping("/hplus/rest/loginuser")
    public ResponseEntity loginUser(@RequestBody Login login) throws LoginFailedException{
        System.out.println("Login get username Rest Controller: "
        +  login.getUserName() + " " + login.getPassword());
        User user = userRepository.searchByName(login.getUserName());

        if(user == null){
            return ResponseEntity.status(404).build();
        }

        if(user.getUsername().equals(login.getUserName()) &&
        user.getPassword().equals(login.getPassword())){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            throw new LoginFailedException("Invalid Username or Password");
        }
    }
}
