package com.example.shaksham.model;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class Product {
	
	private int productId;
	private int catId;
	private String productName;
	private String description;
	private double price;
	private Timestamp date;
	private String shgId;
	
	public Product() {
		
	}

	public Product(int productId, int catId, String productName, String description, double price, Timestamp date,
			String shgId) {
		super();
		this.productId = productId;
		this.catId = catId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.date = date;
		this.shgId = shgId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
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
	
}
