package com.eshoppingzone.productservice.exception;

public class ProductException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public ProductException(String message) {
		super(message);
	}
	
	public static String productAlreadyExists() {
		return "Product with given productId already exists";
	}
	
	public static String productNotPresent() {
		return "Product with given productId does not exist. Try adding the product first";
	}
}
