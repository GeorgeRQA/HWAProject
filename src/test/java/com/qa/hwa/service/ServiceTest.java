package com.qa.hwa.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.hwa.domain.Supermarket;
import com.qa.hwa.repo.SupermarketRepo;

@SpringBootTest
public class ServiceTest {
	
	@Autowired 
	private SupermarketService service;
	
	@MockBean
	private SupermarketRepo repo;
	
	@Test
	void testCreate() {
		Supermarket apple = new Supermarket("Apple", 0.49, 10);
		Supermarket addedApple = new Supermarket(1L, "Apple", 0.49, 10);
		
		Mockito.when(this.repo.save(apple)).thenReturn(addedApple);
		
		assertThat(this.service.create(apple)).isEqualTo(addedApple);
		
		Mockito.verify(this.repo, Mockito.times(1)).save(apple);
	}
	
//	@Test
////	void testReadAll() {
////		List<Supermarket> addedApple = new List<Supermarket> [{"id":1, "name":"apple", "price":0.49, "quantity":10}];
//		
//		Mockito.when(this.repo.findAll()).thenReturn(addedApple);
//	}
	
//	@Test
//	void testDelete() {
//		Supermarket apple = new Supermarket("Apple", 0.49, 10);
//		Supermarket addedApple = new Supermarket(1L, "Apple", 0.49, 10);
//		
//		Mockito.when(this.repo.save(apple)).thenReturn(addedApple);
//		
//		Mockito.when(this.repo.deleteById(1L)).thenReturn(true);
//		
//		assertThat(this.service.delete(1L).isEqualTo(true));
//	}
//	@Test
//	void testReadOne() {
//		Optional<Supermarket> addedApple = Optional.of(new Supermarket(1L, "Apple", 0.49, 10));
//		
//		Mockito.when(this.repo.findById(1L)).thenReturn(addedApple);
//		
//		assertThat(this.service.getOne(1L)).isEqualTo(addedApple);
//		
//		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
//	}
//	@Test
//	void testUpdate() {
//		Supermarket apple = new Supermarket(1L, "Apple", 0.49, 10);
//		Supermarket updateApple = new Supermarket("Pear", 0.49,10);
//		
//		Mockito.when(this.repo.save(apple)).thenReturn(updateApple);
//		
//		assertThat(this.service.update(1L, apple)).isEqualTo(updateApple);
//	}
}
