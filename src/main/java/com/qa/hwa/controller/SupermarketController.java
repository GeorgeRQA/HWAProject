package com.qa.hwa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwa.domain.Supermarket;
import com.qa.hwa.repo.SupermarketRepo;

@RestController
public class SupermarketController {
	
private SupermarketRepo repo;
	
	public SupermarketController(SupermarketRepo repo) {
		this.repo = repo; 
	}

	private List<Supermarket> supermarketList = new ArrayList<>();
	
	//Create
	@PostMapping("/create")
	public ResponseEntity<Supermarket> addItem(@RequestBody Supermarket supermarket){
		return new ResponseEntity<Supermarket>(this.repo.save(supermarket),HttpStatus.CREATED);
	}
	
	//Read all
	@GetMapping("/getAll")
	public ResponseEntity<List<Supermarket>> getAll(){
		return ResponseEntity.ok(this.repo.findAll());
	}
	
	//Read one
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Optional<Supermarket>> getItemById(@PathVariable Long id) {
		return ResponseEntity.ok(this.repo.findById(id));
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Optional<Supermarket>> update(@PathParam("name") String name, @PathParam("price") double price, @PathParam("quantity")int quantity, @PathVariable Long id){
	return ResponseEntity.ok(this.repo.findById(id));
	}
	
	//Delete
	@DeleteMapping("/remove/{id}")
	public boolean removeItem(@PathVariable Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	
}

