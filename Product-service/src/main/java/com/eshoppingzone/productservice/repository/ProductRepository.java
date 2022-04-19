package com.eshoppingzone.productservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.eshoppingzone.productservice.entities.Product;

public interface ProductRepository extends MongoRepository<Product, Integer>{
	
	@Query("{'productName': ?0}")
	Optional<Product> findByProductName(String productName);
}
