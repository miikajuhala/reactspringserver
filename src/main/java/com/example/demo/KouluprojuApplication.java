package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.web.Spot;
import com.example.demo.web.SpotRepository;
import com.example.demo.web.User;
import com.example.demo.web.UserRepository;



@SpringBootApplication
public class KouluprojuApplication { 

	public static void main(String[] args) { 
		SpringApplication.run(KouluprojuApplication.class, args);
	} 

	
	@Bean
    public CommandLineRunner studentDemo(UserRepository urepository, SpotRepository srepository) {
        return (args) -> { 

        	
        	

			List<Spot> spotit;
			
				User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
				User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
				urepository.save(user1);
				urepository.save(user2);
				System.out.println(urepository.findAll());
				
				Spot spot1 = new Spot(false,true);
				Spot spot2 = new Spot(false,true);
				Spot spot3 = new Spot(false,true);
				Spot spot4 = new Spot(false,true);
				
				
				//spot1.setSpotusername(urepository.findByUsername("user").getUsername());
				//spot2.setSpotusername(urepository.findByUsername("admin").getUsername());
				//spot3.setSpotusername(urepository.findByUsername("admin").getUsername());
				//spot4.setSpotusername(urepository.findByUsername("user").getUsername());
				
				//srepository.save(spot1);
				//srepository.save(spot2);
				//srepository.save(spot3);
				//srepository.save(spot4);
	
				System.out.println("________-------______------_______----"+srepository.findAll());
				
				
        	};

	}
	

	
	
}
