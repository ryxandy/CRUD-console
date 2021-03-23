package com.wipro.persistence;

public class Product {

	private String name;	
	private Double price;
	private String description;
	private int quantity;
	private String category;

	
	public Product() {
		super();
	}
	
	public Product(String name, Double price, String description, int quantity, String category) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.category = category;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", description=" + description + ", quantity=" + quantity
				+ ", category=" + category + "]";
	}

}
