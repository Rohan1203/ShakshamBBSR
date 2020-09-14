package com.example.shaksham.controller;

import java.security.Timestamp;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shaksham.dao.ProductCrudDao;

/*
 * author-Preeti098
 */
@RestController
@RequestMapping("/product")
@ComponentScan("com.example.EcomHandcrafting.controller")
public class ProductCrudController<Int> { 
	
	@Autowired()
	ProductCrudDao product;
	
	
	@GetMapping("/add")
	public String welcome() {
		return "Welcome to ShakSham";
	}
	
	@RequestMapping("/addProduct/{productId}/{catId}/{productName}/{description}/{price}/{shgId}")
    @ResponseBody
    public String addProduct(@PathVariable Int productId,@PathVariable Int catId,
    		@PathVariable String productName,@PathVariable String description,
    		@PathVariable Double price,@PathVariable String shgId){
		
		
       if(product.addProduct(productId,catId,productName,description,price,shgId) >= 1){
            return "Item Added Successfully";
        }else{
            return "Something went wrong !pls check the details again";
        }
		
		
	}
	
	/*@RequestMapping("/shg/{productId}")
	public String shg(@PathVariable String productId) {
		return productId;
		
	}*/
	

}
