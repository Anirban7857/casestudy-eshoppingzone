package com.eshoppingzone.productservice.entities;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="product")
public class Product {
	
	@Transient
	public static final String SEQUENCE_NAME ="products_sequence";
	
	@Id
	private long productId;
	
	@NotNull(message = "productType cannot be null")
	private String productType;
	
	@NotNull(message = "productName cannot be null")
	private String productName;
	
	@NotNull(message = "productType cannot be null")
	private String category;
	
	private Map<String, Double> rating;
	private Map<String, String> review;
	
	@NotNull(message = "productType cannot be null")
	private List<String> image;
	
	@NotNull(message = "productType cannot be null")
	@Min(value = 1, message = "price cannot be less than 1")
	private double price;
	
	private String description;
	private Map<String, String> specification;
	
	public Product() {
		super();
	}

	

	public Product(long productId, @NotNull(message = "productType cannot be null") String productType,
			@NotNull(message = "productName cannot be null") String productName,
			@NotNull(message = "productType cannot be null") String category, Map<String, Double> rating,
			Map<String, String> review, @NotNull(message = "productType cannot be null") List<String> image,
			@NotNull(message = "productType cannot be null") @Min(value = 1, message = "price cannot be less than 1") double price,
			String description, Map<String, String> specification) {
		super();
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
		this.category = category;
		this.rating = rating;
		this.review = review;
		this.image = image;
		this.price = price;
		this.description = description;
		this.specification = specification;
	}



	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Map<String, Double> getRating() {
		return rating;
	}

	public void setRating(Map<String, Double> rating) {
		this.rating = rating;
	}

	public Map<String, String> getReview() {
		return review;
	}

	public void setReview(Map<String, String> review) {
		this.review = review;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, String> getSpecification() {
		return specification;
	}

	public void setSpecification(Map<String, String> specification) {
		this.specification = specification;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, description, image, price, productId, productName, productType, rating, review,
				specification);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& Objects.equals(image, other.image)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& productId == other.productId && Objects.equals(productName, other.productName)
				&& Objects.equals(productType, other.productType) && Objects.equals(rating, other.rating)
				&& Objects.equals(review, other.review) && Objects.equals(specification, other.specification);
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productType=" + productType + ", productName=" + productName
				+ ", category=" + category + ", rating=" + rating + ", review=" + review + ", image=" + image
				+ ", price=" + price + ", description=" + description + ", specification=" + specification + "]";
	}

	
}