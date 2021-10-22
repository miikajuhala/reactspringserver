package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;





@RestController
@RequestMapping("/api")
@CrossOrigin
public class RestController1 {
	

	
	 
@Autowired
private UserRepository urepository;
	
	
	
@RequestMapping(value="/users", method = RequestMethod.GET)
public @ResponseBody List<User> Rest() {	
    return urepository.findAll(); 
}  
	
}