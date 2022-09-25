package com.spring.transactionapis.service.impl;

import com.spring.transactionapis.entities.PersonalAccount;
import com.spring.transactionapis.entities.Transaction;
import com.spring.transactionapis.exceptions.ApiException;
import com.spring.transactionapis.model.PersonalAccountModel;
import com.spring.transactionapis.repositories.PersonalAcountRepository;
import com.spring.transactionapis.repositories.TransactionRepository;
import com.spring.transactionapis.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final PersonalAcountRepository personalAcountRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public PersonalAccountModel makePayment(Long personalAccountId) {
        PersonalAccount accountToGetPayment = personalAcountRepository.findById(personalAccountId)
                .orElseThrow(()-> new NoSuchElementException("account with id: " + personalAccountId + "not found"));
        BigDecimal accountBalance = accountToGetPayment.getBalance();
        Transaction transaction = new Transaction();
        transaction.setCreatedDate(LocalDateTime.now());
        transaction.setOperationSum(BigDecimal.valueOf(-1.1));
        transaction.setPersonalAccount(accountToGetPayment);
        if (accountBalance.compareTo(BigDecimal.valueOf(1.1)) < 0){
            transaction.setStatus("FAILED");
            transactionRepository.save(transaction);
            throw new ApiException("Can not get payment from account: " + personalAccountId + " with balance: " +accountBalance);
        }
        accountToGetPayment.setBalance(accountBalance.subtract(BigDecimal.valueOf(1.1)));
        transaction.setStatus("SUCCESS");
        transactionRepository.save(transaction);
        return personalAcountRepository.save(accountToGetPayment).toModel();
    }
}
