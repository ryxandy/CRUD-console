package com.wipro.persistence;

public class Product {

	private String name;	
	private Double price;
	private String description;
	private int quantity;
	private String category;
	private String subCollection;
	private String image;

	
	public Product() {
		super();
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



	public String getSubCollection() {
		return subCollection;
	}



	public void setSubCollection(String subCollection) {
		this.subCollection = subCollection;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", description=" + description + ", quantity=" + quantity
				+ ", category=" + category + ", subCollection=" + subCollection + "]";
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}
	
}
