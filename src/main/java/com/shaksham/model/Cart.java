package com.shaksham.model;

import java.sql.Timestamp;

public class Cart {

	
	private int idCart;
	private int productId;
	private int customerId;
	private int productQuantity;
	private String productDetails;
	private Timestamp date;
	private Double price;
	
	public Cart() {
		
	}
	public Cart(int idCart, int productId, int customerId, int productQuantity, String productDetails, Timestamp date,
			Double price) {
		super();
		this.idCart = idCart;
		this.productId = productId;
		this.customerId = customerId;
		this.productQuantity = productQuantity;
		this.productDetails = productDetails;
		this.date = date;
		this.price = price;
	}
	public int getIdCart() {
		return idCart;
	}
	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	
	
}
