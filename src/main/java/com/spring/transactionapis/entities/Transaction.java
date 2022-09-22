package com.spring.transactionapis.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private Date createdDate;
    private Date finishDate;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private PersonalAccount personalAccount;
}
