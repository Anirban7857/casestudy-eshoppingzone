package com.eshoppingzone.productservice.services;

import java.util.List;

import javax.validation.ConstraintViolationException;

import com.eshoppingzone.productservice.entities.Product;
import com.eshoppingzone.productservice.exception.ProductException;

public interface ProductService {

	public List<Product> getAllProducts();

	public Product addProducts(Product product) throws ConstraintViolationException, ProductException;

	public Product getProductById(long id);

	public List<Product> getProductByName(String productName);

	public Product updateProducts(Product product) throws ConstraintViolationException;

	public void deleteProductById(long id) throws Exception;

	public List<Product> getProductByCategory(String category);

	public List<Product> getProductByProductType(String productType);
	
	
}
