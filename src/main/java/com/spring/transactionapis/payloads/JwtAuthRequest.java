package com.spring.transactionapis.payloads;

import lombok.Data;

@Data
public class JwtAuthRequest {
    private String email;
    private String password;
}
