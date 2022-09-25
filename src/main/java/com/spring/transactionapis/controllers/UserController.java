package com.spring.transactionapis.controllers;

import com.spring.transactionapis.model.PersonalAccountModel;
import com.spring.transactionapis.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final TransactionService transactionService;
    @GetMapping("/withdraw-balance")
    public PersonalAccountModel withdraw(@RequestParam Long personalAccountId) {
        return transactionService.makePayment(personalAccountId);
    }
}
