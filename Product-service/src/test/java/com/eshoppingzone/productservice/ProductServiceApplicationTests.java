package com.eshoppingzone.productservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.eshoppingzone.productservice.entities.Product;
import com.eshoppingzone.productservice.exception.ProductException;
import com.eshoppingzone.productservice.repository.ProductRepository;
import com.eshoppingzone.productservice.services.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceApplicationTests {
	
	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void getAllProductsTest() {
		when(productRepository.findAll()).thenReturn(Stream
				.of(new Product(1001, "electronics", "redmi9a", "mobile", null,
						null, null, 9999, "budget phone", null),
					new Product(1002, "electronics", "redmi11a", "mobile", null,
						null, null, 9999, "budget phone", null))
				.collect(Collectors.toList()));
		assertEquals(2, productService.getAllProducts().size());		
	}
	
	@Test
	public void addProductsTest() throws ConstraintViolationException, ProductException {
		Product product = new Product(1002, "electronics", "redmi11a", "mobile", null,
				null, null, 9999, "budget phone", null);
		when(productRepository.save(product)).thenReturn(product);
		assertEquals(product, productService.addProducts(product));
	}
	
	@Test
	public void updateProductsTest() throws ConstraintViolationException{
		Product product = new Product(1002, "electronics", "redmi11a", "mobile", null,
				null, null, 9999, "budget phone", null);
		when(productRepository.save(product)).thenReturn(product);
		assertEquals(product, productService.updateProducts(product));
	}
	
	@Test
	public void deleteProductByIdTest() throws Exception{
		long id = 1001;
		productService.deleteProductById(id);
		verify(productRepository, times(1)).deleteById(id);
	}
	
	@Test
	public void getProductByIdTest() {
	
		long id = 1L;
		Product product = new Product(id, "electronics", "redmi9a", "mobile", null,
				null, null, 9999, "budget phone", null);
		when(productRepository.findById(id)).thenReturn(product);
		assertEquals(product, productService.getProductById(id));
		
	}
	
	@Test
	public void getProductByNameTest() {
		
		String productName = "redmi9a";
		when(productRepository.findByProductName(productName)).thenReturn(Stream
				.of(new Product(1001, "electronics", productName, "mobile", null,
						null, null, 9999, "budget phone", null),
					new Product(1002, "electronics", productName, "mobile", null,
						null, null, 9999, "budget phone", null))
				.collect(Collectors.toList()));
		assertEquals(2, productService.getProductByName(productName).size());
		
	}
	
	@Test
	public void getProductByCategoryTest() {
		
		String category = "mobile";
		when(productRepository.findByCategory(category)).thenReturn(Stream
				.of(new Product(1001, "electronics", "redmi9a", category, null,
						null, null, 9999, "budget phone", null),
					new Product(1002, "electronics", "redmi11a", category, null,
						null, null, 9999, "budget phone", null))
				.collect(Collectors.toList()));
		assertEquals(2, productService.getProductByCategory(category).size());
		
	}
	
	@Test
	public void getProductByProductTypeTest() {
		
		String productType = "electronics";
		when(productRepository.findByProductType(productType)).thenReturn(Stream
				.of(new Product(1001, productType, "redmi9a", "mobile", null,
						null, null, 9999, "budget phone", null),
					new Product(1002, productType, "redmi11a", "mobile", null,
						null, null, 9999, "budget phone", null))
				.collect(Collectors.toList()));
		assertEquals(2, productService.getProductByProductType(productType).size());
		
	}


}
