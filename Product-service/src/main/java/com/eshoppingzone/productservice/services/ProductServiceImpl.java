package com.eshoppingzone.productservice.services;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshoppingzone.productservice.entities.Product;
import com.eshoppingzone.productservice.exception.ProductException;
import com.eshoppingzone.productservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
	
		return productRepository.findAll();
	}

	@Override
	public Product addProducts(Product product) throws ConstraintViolationException, ProductException{
		
		Product findProduct = productRepository.findById(product.getProductId());
		
		if(findProduct != null) {
			throw new ProductException(ProductException.productAlreadyExists());
		}else {
			productRepository.save(product);
		}
		
		return product;
	}

	@Override
	public Product getProductById(long id) {
		return productRepository.findById(id);
	}
	

	@Override
	public List<Product> getProductByName(String productName) {
		List<Product> productList = productRepository.findByProductName(productName);
		return productList;
	}

	@Override
	public Product updateProducts(Product product) throws ConstraintViolationException{
		
//		Product findProduct = productRepository.findById(product.getProductId());
//		
//		if(findProduct == null) {
//			throw new ProductException(ProductException.productNotPresent());
//		}else {
//			productRepository.save(product);
//		}
		productRepository.save(product);
		return product;
		
	}

	@Override
	public void deleteProductById(long id) throws Exception{
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		List<Product> productList = productRepository.findByCategory(category);
		return productList;
		
	}

	@Override
	public List<Product> getProductByProductType(String productType) {
		List<Product> productList = productRepository.findByProductType(productType);
		return productList;
	}
	

}
