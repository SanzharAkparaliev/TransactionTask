package com.spring.transactionapis.repositories;

import com.spring.transactionapis.entities.PersonalAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalAcountRepository extends JpaRepository<PersonalAccount,Long> {
}
