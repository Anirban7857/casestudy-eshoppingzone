package com.eshoppingzone.productservice.resource;

import java.util.List;
import java.util.Optional;

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
import com.eshoppingzone.productservice.services.ProductService;

@RestController
@RequestMapping("/eshoppingzone")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		
		List<Product> list = productService.getAllProducts();
		return new ResponseEntity<>(list, list.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/addproducts")
	public ResponseEntity<?> addProducts(@RequestBody Product product) {
//		try {
//			orderService.placeOrder(order);
//			return new ResponseEntity<>(order, HttpStatus.OK);
//		}catch (ConstraintViolationException e) {
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
//		}catch(OrderException e) {
//			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
//		}
		productService.addProducts(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@GetMapping("/productId/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable(value = "id") int id) {
		Optional<Product> product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
	
	@GetMapping("/productName/{productName}")
    public ResponseEntity<Optional<Product>> getProductByName(@PathVariable(value = "productName") String productName) {
		Optional<Product> product = productService.getProductByName(productName);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
	
	@PutMapping("/updateProducts")
	public ResponseEntity<?> updateProducts(@RequestBody Product product){
		
		productService.updateProducts(product);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@DeleteMapping("/productId/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") int id){
		productService.deleteProductById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
