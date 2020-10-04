package com.shaksham.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//import com.example.EcomHandcrafting.model.Product;
import com.shaksham.model.Cart;
import com.shaksham.model.Product;



/**
 * 
 * @author preeti-098
 *
 * @param <INT>
 */

@Repository
public class addCartDao<INT> {

	
	@Autowired
    JdbcTemplate template;
	
	public int checkCart(int productId) {
		
		 Product p = new Product(); 
		 p.setProductId(productId); 
		 String sql="select noOfAvailability from product where productId= ?;"; 
		 // noOfAvailability=template.queryForObject(sql,new Object[]{p.getNoOfAvailability()}); //template.queryForObject
		 return template.queryForObject(sql, new Object[] {productId},(Integer.class));
		 
	}

	public int addToCart(int productId, int customerId, int productQuantity, String productDetails, Double price) {

		
		/*
		 * Product p = new Product(); p.setProductId(productId); String
		 * sql="select noOfAvailability from product where productId= ?;"; String
		 * noOfAvailability=template.queryForObject(sql,new
		 * Object[]{p.getNoOfAvailability()}); //template.queryForObject
		 * System.out.println(noOfAvailability);
		 */

		String query = "INSERT INTO cart(idCart,productId,customerId,productQuantity,productDetails,date,price) VALUES(default,?,?,?,?,CURRENT_TIMESTAMP,?);";
		return template.update(query, new Object[] { productId, customerId, productQuantity, productDetails, price });
	}

	/***
	 * @view mycart dao
	 * @param customerId
	 * 
	 */
	public List<Cart> getAll(int customerId) {
		List<Cart> cart = new ArrayList<Cart>();
		Cart c=new Cart();
		c.setCustomerId(customerId);
		String sql = "select * from Cart where customerId=? ;";
		cart = template.query(sql,BeanPropertyRowMapper.newInstance(Cart.class), new Object[] {c.getCustomerId()});
		return cart;
	}
	
}
