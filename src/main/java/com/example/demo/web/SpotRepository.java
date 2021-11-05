package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface SpotRepository extends CrudRepository<Spot, Long> {
	Optional<Spot> findById(Long id);
	Spot findBySpotuser(User spotuser);
	List <Spot> findAll();
	List <Spot> findBySpotusername(String spotusername);

}
