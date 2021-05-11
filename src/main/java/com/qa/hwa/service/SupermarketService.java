package com.qa.hwa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.hwa.domain.Supermarket;
import com.qa.hwa.repo.SupermarketRepo;

@Service
public class SupermarketService {

	private SupermarketRepo repo;
	
	public SupermarketService(SupermarketRepo repo) {
		this.repo=repo;
	}
	
	public Supermarket create(Supermarket s) {
		return this.repo.save(s);
	}
	
	public List<Supermarket> getAll(){
		return this.repo.findAll();
	}
	
	public Supermarket getOne(Long id) {
		Optional<Supermarket> optionalItem = this.repo.findById(id);
		return optionalItem.get();
	}
	
	public Supermarket update(Long id, Supermarket newSupermarket) {
		Optional<Supermarket> existingOptional = this.repo.findById(id);
		Supermarket existing = existingOptional.get();
		
		existing.setName(newSupermarket.getName());
		existing.setPrice(newSupermarket.getPrice());
		existing.setQuantity(newSupermarket.getQuantity());
		
		return this.repo.save(existing);
	}
	
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
