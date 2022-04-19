package com.eshoppingzone.productservice.services;

import java.util.List;
import java.util.Optional;

import com.eshoppingzone.productservice.entities.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public void addProducts(Product product);

	public Optional<Product> getProductById(int id);

	public Optional<Product> getProductByName(String productName);

	public void updateProducts(Product product);

	public void deleteProductById(int id);
	
	
}
