package com.spring.transactionapis.impl;

import com.spring.transactionapis.config.AppConstants;
import com.spring.transactionapis.entities.Role;
import com.spring.transactionapis.entities.User;
import com.spring.transactionapis.payloads.UserDto;
import com.spring.transactionapis.repositories.RoleRepository;
import com.spring.transactionapis.repositories.UserRepository;
import com.spring.transactionapis.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto registerNewUser(UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        Role role = this.roleRepository.findById((long) AppConstants.NORMAL_USER).get();
        user.getRoles().add(role);
        User newUser = this.userRepository.save(user);
        return modelMapper.map(newUser,UserDto.class);
    }


}
