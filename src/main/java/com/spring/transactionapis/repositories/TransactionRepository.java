package com.spring.transactionapis.repositories;

import com.spring.transactionapis.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
