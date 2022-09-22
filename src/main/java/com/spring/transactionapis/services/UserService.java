package com.spring.transactionapis.services;

import com.spring.transactionapis.payloads.UserDto;

import java.util.List;


public interface UserService {

    UserDto registerNewUser(UserDto user);

}
