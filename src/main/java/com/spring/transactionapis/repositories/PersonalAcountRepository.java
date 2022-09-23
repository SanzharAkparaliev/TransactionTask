package com.spring.transactionapis.repositories;

import com.spring.transactionapis.entities.PersonalAccount;
import com.spring.transactionapis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonalAcountRepository extends JpaRepository<PersonalAccount,Long> {
    Optional<PersonalAccount> findByUser(User user);
}
