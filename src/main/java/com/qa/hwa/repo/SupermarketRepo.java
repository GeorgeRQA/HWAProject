package com.qa.hwa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.hwa.domain.Supermarket;

@Repository
public interface SupermarketRepo extends JpaRepository<Supermarket, Long>{

}
