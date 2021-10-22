package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.web.User;
import com.example.demo.web.UserRepository;



@SpringBootApplication
public class KouluprojuApplication { 

	public static void main(String[] args) { 
		SpringApplication.run(KouluprojuApplication.class, args);
	} 

	
	@Bean
    public CommandLineRunner studentDemo(UserRepository urepository) {
        return (args) -> { 


				User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
				User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
				urepository.save(user1);
				urepository.save(user2);
				System.out.println(urepository.findAll());

        	};

	}
	

	
	
}
