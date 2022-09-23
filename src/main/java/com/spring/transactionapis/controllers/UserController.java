package com.spring.transactionapis.controllers;

import com.spring.transactionapis.entities.User;
import com.spring.transactionapis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/withdraw-balance")
    public String withdraw(Principal principal) {
        User user = userService.findByUserName(principal.getName()).get();
        String result = userService.withdrawBalance(user);
        return  result;
    }
}
