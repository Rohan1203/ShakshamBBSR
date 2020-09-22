package com.shaksham.dao;

import java.security.Timestamp;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shaksham.model.Product;



/*
 * author-Preeti098
 */
@Repository
public class ProductCrudDao<Int> {
	
	@Autowired
    JdbcTemplate template;
	
	public int addProduct(String catName,String productName,String description,
			Double price,String shgId,Int noOfAvailability){
		
        String query = "INSERT INTO product(productId,catName,productName,description,price,date,shgId,noOfAvailability) VALUES(default,?,?,?,?,CURRENT_TIMESTAMP,?,?);";
        return template.update(query,new Object[] {catName,productName,description,price,shgId,noOfAvailability});
    }
	/*
	 * Author Supriya
	 */
	public int deleteProduct(int productId)
	{
		Product p = new Product(); 
        p.setProductId(productId);
		String sql = "delete from product where productId = ?;";
		return template.update(sql, new Object[] {p.getProductId()});
	      
	      
	}

}


