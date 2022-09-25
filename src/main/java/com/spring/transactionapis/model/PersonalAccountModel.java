package com.spring.transactionapis.model;

import com.spring.transactionapis.entities.User;
import lombok.*;

import java.math.BigDecimal;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalAccountModel {
    Long id;
    User user;
    BigDecimal balance;
}
