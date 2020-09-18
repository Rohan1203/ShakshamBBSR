package com.example.shaksham.model;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class Product {
	
	private int productId;
	private String catName;
	private String productName;
	private String description;
	private double price;
	private Timestamp date;
	private String shgId;
	private int noOfAvailability;
	
	public Product() {
		
	}
	
	public Product(int productId, String catName, String productName, String description, double price, Timestamp date,
			String shgId, int noOfAvailability) {
		super();
		this.productId = productId;
		this.catName = catName;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.date = date;
		this.shgId = shgId;
		this.noOfAvailability = noOfAvailability;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getShgId() {
		return shgId;
	}

	public void setShgId(String shgId) {
		this.shgId = shgId;
	}

	public int getNoOfAvailability() {
		return noOfAvailability;
	}

	public void setNoOfAvailability(int noOfAvailability) {
		this.noOfAvailability = noOfAvailability;
	}
	

	
	
	
}
