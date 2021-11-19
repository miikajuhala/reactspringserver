package com.example.demo.web;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.nio.charset.StandardCharsets;
import java.rmi.ServerException;
import java.security.Principal;
import java.util.List;





@RestController
@RequestMapping("/api")
@CrossOrigin
public class RestController1 {
	

	
	 
@Autowired
private UserRepository urepository;

@Autowired
private SpotRepository srepository;
	
	
@RequestMapping(value="/users", method = RequestMethod.GET)
public @ResponseBody List<User> Rest() {	
    return urepository.findAll(); 
}  

@RequestMapping(value="/spots", method = RequestMethod.GET)
public @ResponseBody List<Spot> RestSpot() {	
    return srepository.findAll(); 
}  
//chekki onko kyseinen käyttäjä
//haetaan kaikki spotit missä kyseinen useri
@RequestMapping(value="/spots/myspots/{username}", method = RequestMethod.GET)
public @ResponseBody List<Spot> RestMySpots(@PathVariable("username") String username) {	
    return srepository.findBySpotuser(urepository.findByUsername(username)); 
}  


//Lisää uudet parkkipaikan 
@PostMapping(value="/spots/add")
public ResponseEntity<Spot> create(@RequestBody Spot newSpot) throws ServerException {
    Spot spot = srepository.save(newSpot);
    if (spot == null) {
        throw new ServerException(null);
    } else {
        return new ResponseEntity<>(spot, HttpStatus.CREATED);
    }
}

@PutMapping("spots/newres/{id}")
public ResponseEntity<Spot> updateSpot(@PathVariable(value = "id") Long spotId,
     @RequestBody Spot spotDetails) throws ResourceNotFoundException {
    Spot spot = srepository.findById(spotId)
    .orElseThrow(() -> new ResourceNotFoundException("Spot not found for this id :: " + spotId));

    //otetaan frontista currentuser ja haetaan sillä kannasta username ja tallennetaan spottiin
    //jatkokehityksenä voisi kaikki tiedot hakea controllerin sisällä securitystä.
    //myös onko premium voisi hake vaan id:n perusteella kannasta niin kukaa ei pääse sörkkimään
    spot.setReserved(true);
    spot.setPremium(spotDetails.getPremium());
    spot.setSpotuser(urepository.findByUsername(spotDetails.getSpotuser().getUsername()));
    final Spot updatedSpot = srepository.save(spot);
    return ResponseEntity.ok(updatedSpot);
}

//tähän myös security että onko kyseinen käyttäjä
@PutMapping("spots/delres/{id}")
public ResponseEntity<Spot> delSpot(@PathVariable(value = "id") Long spotId,
     @RequestBody Spot spotDetails) throws ResourceNotFoundException {
    Spot spot = srepository.findById(spotId)
    .orElseThrow(() -> new ResourceNotFoundException("Spot not found for this id :: " + spotId));

    spot.setReserved(false);
    spot.setSpotuser(null);
    final Spot updatedSpot = srepository.save(spot);
    return ResponseEntity.ok(updatedSpot);
}


} 