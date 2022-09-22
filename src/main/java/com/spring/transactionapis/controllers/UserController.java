package com.spring.transactionapis.controllers;

import com.spring.transactionapis.payloads.ApiResponse;
import com.spring.transactionapis.payloads.UserDto;
import com.spring.transactionapis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/")
    public String sayHello(){
        return  "String";
    }
}
