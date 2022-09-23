package com.spring.transactionapis.service;

import com.spring.transactionapis.config.AppConstants;
import com.spring.transactionapis.entities.PersonalAccount;
import com.spring.transactionapis.entities.Role;
import com.spring.transactionapis.entities.User;
import com.spring.transactionapis.payloads.UserDto;
import com.spring.transactionapis.repositories.PersonalAcountRepository;
import com.spring.transactionapis.repositories.RoleRepository;
import com.spring.transactionapis.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class UserService  {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PersonalAcountRepository personalAcountRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDto registerNewUser(UserDto userDto) {
        User user = modelMapper.map(userDto,User.class);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        Role role = this.roleRepository.findById((long) AppConstants.NORMAL_USER).get();
        user.getRoles().add(role);
        User newUser = this.userRepository.save(user);

        PersonalAccount account = new PersonalAccount();
        account.setUser(newUser);
        account.setBalance(AppConstants.DEFAULT_BALANCE);
        personalAcountRepository.save(account);

        return modelMapper.map(newUser,UserDto.class);
    }

    public String withdrawBalance(User user){
        BigDecimal wBalance = new BigDecimal("1.1");
        PersonalAccount account = personalAcountRepository.findByUser(user).get();
        account.setBalance(account.getBalance().subtract(wBalance));
        personalAcountRepository.save(account);
        return "Succesfully";
    }

    public Optional<User> findByUserName(String username){
        return  userRepository.findByEmail(username);
    }


}
