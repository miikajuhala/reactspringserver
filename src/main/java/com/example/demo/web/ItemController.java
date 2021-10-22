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





@Controller
@CrossOrigin
public class ItemController {
	

	
	 
	@Autowired
	private UserRepository urepository;
	
	
 @RequestMapping(value= {"/index"})
    public String studentList(Model model) {	
	 model.addAttribute("users", urepository.findAll());
        return "test"; 
    }
	
	
 @RequestMapping(value="/loginpage")
 public String login() {
     return "loginpage";
 }
	
 @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
 public String save(User user){
  urepository.save(user);  
  System.out.println("HERE ADFADFDFKKASSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"+user.toString());
  return "test";
 }
 
 @RequestMapping(value="/signup")
 public String signup(Model model) {
	 model.addAttribute("user", new User());
     return "signup";
 }
 
 
	
	
}
