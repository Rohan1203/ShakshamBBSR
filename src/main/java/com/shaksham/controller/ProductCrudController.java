package com.shaksham.controller;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shaksham.dao.ProductCrudDao;

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
	
	@RequestMapping("/addProduct/{catName}/{productName}/{description}/{price}/{shgId}/{noOfAvailability}")
    @ResponseBody
    public String addProduct(@PathVariable String catName,
    		@PathVariable String productName,@PathVariable String description,
    		@PathVariable Double price,@PathVariable String shgId,@PathVariable Int noOfAvailability){
		
		
       if(product.addProduct(catName,productName,description,price,shgId,noOfAvailability) >= 1){
            return "Item Added Successfully";
        }else{
            return "Something went wrong !pls check the details again";
        }
		
		
	}
	
	/*@RequestMapping("/shg/{productId}")
	public String shg(@PathVariable String productId) {
		return productId;
		
	}*/
	
/*
 * Author Supriya
 */
	@RequestMapping(value="/prod/{pid}",method = RequestMethod.GET)
	public String productDelete(@PathVariable int pid) {
		int a;
		a=product.deleteProduct(pid);
		if(a==1)
		return "Delete Successfull";
		else
		return "Delete unsuccessful";
		
	}
	
	
	
	

}
