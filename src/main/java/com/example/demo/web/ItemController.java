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
import org.springframework.security.crypto.bcrypt.BCrypt;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	 System.out.println("VITTU SAATANA_____________--------------------______________-----------");
	 String oldpass= user.getPasswordHash();
	 System.out.println(oldpass+"OLDPASS______________________________");
	
	 String newpass = BCrypt.hashpw(oldpass, BCrypt.gensalt());
	 
	 user.setPasswordHash(newpass);
	 System.out.println("HASHATTY PASSWORDI"+newpass);
	 
  urepository.save(user);  
  System.out.println(user.toString());
  
  return "redirect:loginpage";
 }
 


@RequestMapping(value="/signup")
 public String signup(Model model) {
	 model.addAttribute("user", new User());
     return "signup";
 }
	
 @Controller
public class SecurityController {

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
     return principal.getName();
    }
}
 
	
	
}
