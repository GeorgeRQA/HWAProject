package com.qa.hwa.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwa.domain.Supermarket;
import com.qa.hwa.service.SupermarketService;


@RestController
@CrossOrigin
public class SupermarketController {
	
private SupermarketService service;

	public SupermarketController(SupermarketService service) {
		this.service = service; 
	}
	
	//Create
	@PostMapping("/create")
	public ResponseEntity<Supermarket> addItem(@RequestBody Supermarket supermarket){
		return new ResponseEntity<Supermarket>(this.service.create(supermarket),HttpStatus.CREATED);
	}
	
	//Read all
	@GetMapping("/getAll")
	public ResponseEntity<List<Supermarket>> getAll(){
		return ResponseEntity.ok(this.service.getAll());
	}
	
	//Read one
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Supermarket> getItemById(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getOne(id));
	}
	
	//Update
	@PutMapping("/update/{id}")
	public Supermarket update(@PathVariable Long id, @RequestBody Supermarket supermarket){
		this.service.update(id, supermarket);
		return this.service.getOne(id);
	}
	
	//Delete
	@DeleteMapping("/remove/{id}")
	public boolean removeItem(@PathVariable Long id) {
		return this.service.delete(id);
	}
	
	
}

