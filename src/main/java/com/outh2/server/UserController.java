package com.outh2.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping(path = "save")
	ResponseEntity<User> saveUser(User user){
		PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User savedUser=userRepository.save(user);
		
		return new ResponseEntity<>(savedUser,HttpStatus.OK);
		
	}

}
