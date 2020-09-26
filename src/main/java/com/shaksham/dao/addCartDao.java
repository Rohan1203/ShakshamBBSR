package com.shaksham.dao;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
	
	public int addToCart(int productId,int customerId,int productQuantity,
			String productDetails,Double price){
		
		/*
		 * Product p = new Product(); p.setProductId(productId); String sql =
		 * "select noOfAvailability from product where productid= ?;"; return
		 * template.update(sql, new Object[] {p.getProductId()});
		 */
		
        String query = "INSERT INTO cart(cartId,productId,customerId,productQuantity,productDetails,date,price) VALUES(default,?,?,?,?,CURRENT_TIMESTAMP,?) "
        		+ " select noOfAvailability from shaksham.product where productId=?;";
       return template.update(query,new Object[] {productId,customerId,productQuantity,productDetails,price});
    }

}
