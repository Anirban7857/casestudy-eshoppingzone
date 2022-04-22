package com.eshoppingzone.productservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.eshoppingzone.productservice.entities.Product;

public interface ProductRepository extends MongoRepository<Product, Long>{
	
//	@Query("{'productName': ?0}")
	List<Product> findByProductName(String productName);
	
	@Query("{'productId': ?0}")
	Product findById(long id);
	
	List<Product> findByCategory(String category);
	
	List<Product> findByProductType(String productType);
}
