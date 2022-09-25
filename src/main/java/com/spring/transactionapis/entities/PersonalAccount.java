package com.spring.transactionapis.entities;


import com.spring.transactionapis.model.PersonalAccountModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonalAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    private BigDecimal balance;

    public PersonalAccountModel toModel() {
        return PersonalAccountModel.builder()
                .id(id)
                .user(user)
                .balance(balance)
                .build();
    }
}
