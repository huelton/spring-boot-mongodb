package com.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.project.domain.User;
import com.project.repository.UserRepository;

@Configuration
public class Instantiation  implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "maria","maria@gmail.com");
		User joao = new User(null, "joao","joao@gmail.com");
		User bob = new User(null, "bob","bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, joao, bob));
		
	}

}
