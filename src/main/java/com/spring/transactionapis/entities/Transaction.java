package com.spring.transactionapis.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private LocalDateTime createdDate;

    private BigDecimal operationSum;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private PersonalAccount personalAccount;
}
