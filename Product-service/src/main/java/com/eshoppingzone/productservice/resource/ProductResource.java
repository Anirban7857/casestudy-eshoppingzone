package com.eshoppingzone.productservice.resource;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshoppingzone.productservice.entities.Product;
import com.eshoppingzone.productservice.exception.ProductException;
import com.eshoppingzone.productservice.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;




@RestController
@RequestMapping("/eshoppingzone/product")
public class ProductResource {
	
	private final static Logger Logger = LoggerFactory.getLogger(ProductResource.class); 
	
	@Autowired
	private ProductService productService;
	
	//To get all the products
	@Operation(summary = "Get all products")
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		
		List<Product> list = productService.getAllProducts();
		return new ResponseEntity<>(list, list.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		
	}
	
	//To add products 
	@Operation(summary = "Add a product to database")
	@PostMapping("/addproducts")
	public ResponseEntity<?> addProducts(@RequestBody Product product) {
		
		try {
			
			productService.addProducts(product);
			return new ResponseEntity<>(product, HttpStatus.OK);
			
		}catch (ConstraintViolationException e) {
			
			Logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
			
		}catch (ProductException e) {
			
//			Logger.error("Cannot add product. Product with given productId already exists");
			Logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		
		}
		
	}
	
	//To get product by productId
	@Operation(summary = "Get a product by its id")
	@GetMapping("/productId/{id}")
    public ResponseEntity<?> getProductById(@PathVariable(value = "id") long id) {

		Product product = productService.getProductById(id);
		
		if(product == null) {
			
			Logger.info("product with given productId not found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}else {
			
			Logger.info("product with given productId found");
			return new ResponseEntity<>(product, HttpStatus.OK );
			
		}
        
    }
	
	//To get product by productName
	@Operation(summary = "Get products by their name")
	@GetMapping("/productName/{productName}")
    public ResponseEntity<?> getProductByName(@PathVariable(value = "productName") String productName) {
		
		List<Product> productList = productService.getProductByName(productName);
		
		if(productList == null) {
			
			Logger.info("no product found of given productName");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}else {
			
			Logger.info("products found of given productName");
			return new ResponseEntity<>(productList, HttpStatus.OK );
			
		}
    }
	
	//To update products which are already present in database
	@Operation(summary = "Update a product already present in database")
	@PutMapping("/updateProducts")
	public ResponseEntity<?> updateProducts(@RequestBody Product product){
		
		try {
			
			productService.updateProducts(product);
			Logger.info("product updated successfully");
			return new ResponseEntity<>(product, HttpStatus.OK);
			
		}catch (ConstraintViolationException e) {
			
			Logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
			
		}
	}
	
	//To delete products by productId
	@Operation(summary = "Delete a product by its id")
	@DeleteMapping("/productId/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") long id){
		try {
			
			productService.deleteProductById(id);
			Logger.info("product deleted successfully");
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch(Exception e) {
			
			Logger.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
			
		}
	}
	
	//To get product by category
	@Operation(summary = "Get products by category")
	@GetMapping("/category/{category}")
    public ResponseEntity<?> getProductByCategory(@PathVariable(value = "category") String category) {
		
		List<Product> productList = productService.getProductByCategory(category);
		
		if(productList == null) {
			
			Logger.info("no product found of given category");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}else {
			
			Logger.info("products found of given category");
			return new ResponseEntity<>(productList, HttpStatus.OK );
			
		}
    }
	
	//To get product by productName
	@Operation(summary = "Get products by their type")
	@GetMapping("/productType/{productType}")
    public ResponseEntity<?> getProductByType(@PathVariable(value = "productType") String productType) {
		
		List<Product> productList = productService.getProductByProductType(productType);
		
		if(productList == null) {
			
			Logger.info("no product found of given productType");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}else {
			
			Logger.info("products found of given productType");
			return new ResponseEntity<>(productList, HttpStatus.OK );
			
		}
    }
	
}
