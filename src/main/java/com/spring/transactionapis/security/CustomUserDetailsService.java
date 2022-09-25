package com.spring.transactionapis.security;

import com.spring.transactionapis.entities.User;
import com.spring.transactionapis.exceptions.ResourceNotFoundException;
import com.spring.transactionapis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user =  this.userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User "," email "+username));
        return user;
    }
}
