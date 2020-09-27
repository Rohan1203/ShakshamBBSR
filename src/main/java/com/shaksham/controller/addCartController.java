package com.shaksham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.shaksham.dao.addCartDao;
import com.shaksham.model.Cart;
/***
 * 
 * @author preeti-098
 *
 */

@RestController
@RequestMapping("/cart")
@ComponentScan("com.example.EcomHandcrafting.controller")
public class addCartController {
	
	@Autowired
	addCartDao addcart;
	
	@RequestMapping("/addtocart/{productId}/{customerId}/{productQuantity}/{productDetails}/{price}")
    @ResponseBody
    public String addProduct(@PathVariable int productId,
    		@PathVariable int customerId,@PathVariable int productQuantity,
    		@PathVariable String productDetails,@PathVariable Double price){
		
		
       if(addcart.addToCart(productId,customerId,productQuantity,productDetails,price) >= 1){
            return "Item Added to Cart Successfully";
        }else{
            return "Something went wrong !Sorry Out of Stock...";
        }
			
	}
	
	/***
	 * @view cart controller
	 * author:Preeti
	 * @param customerId
	 * @return
	 */
	@RequestMapping(path= "/showcart")
	public List<Cart> allProduct(@PathVariable int customerId){
		return addcart.getAll(customerId);
		
	}

}
