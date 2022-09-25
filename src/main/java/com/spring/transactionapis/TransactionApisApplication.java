package com.spring.transactionapis;

import com.spring.transactionapis.entities.Role;
import com.spring.transactionapis.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class TransactionApisApplication implements CommandLineRunner{

	@Autowired
	private RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(TransactionApisApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return  new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		Optional<Role> role = roleRepository.findByName("NORMAL_USER");
		if(role.isEmpty()){
			System.out.println("created");
			Role newRole = new Role();
			newRole.setId(2L);
			newRole.setName("NORMAL_USER");
			roleRepository.save(newRole);
		}
	}

}
