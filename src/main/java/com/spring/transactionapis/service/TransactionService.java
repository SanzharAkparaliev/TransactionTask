package com.spring.transactionapis.service;


import com.spring.transactionapis.model.PersonalAccountModel;

public interface TransactionService {
    PersonalAccountModel makePayment(Long personalAccountId);
}
