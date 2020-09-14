package com.example.shaksham.dao;

import java.security.Timestamp;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.shaksham.model.Product;



/*
 * author-Preeti098
 */
@Repository
public class ProductCrudDao<Int> {
	
	@Autowired
    JdbcTemplate template;
	
	public int addProduct(Int productId,Int catId,String productName,String description,
			Double price,String shgId){
		
        String query = "INSERT INTO product(productId,catId,productName,description,price,date,shgId) VALUES(?,?,?,?,?,CURRENT_TIMESTAMP,?);";
        return template.update(query,new Object[] {productId,catId,productName,description,price,shgId});
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


