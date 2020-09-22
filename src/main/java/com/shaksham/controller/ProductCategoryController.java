package com.shaksham.controller;

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

import com.shaksham.dao.ProductCategoryDao;
import com.shaksham.model.Category;

//import com.example.EcomHandcrafting.dao.ProductCategoryDao;
//import com.example.EcomHandcrafting.model.Category;

@RestController
@RequestMapping("/product")
@ComponentScan("com.example.EcomHandcrafting.controller")
public class ProductCategoryController {
	
	@Autowired
	ProductCategoryDao productCategoryDao;

	@GetMapping
	public String welcomeMessage() {
		return "welcome";
	}
	
	@GetMapping(path= "/allcategory")
	public List<Category> allProduct(){
		return productCategoryDao.getAll();
		
	}
	
	@RequestMapping("/addProduct/{catId}/{catName}/{catType}")
    @ResponseBody
    public String addCategory(@PathVariable int catId,@PathVariable String catName,
    		@PathVariable String catType){
		
        if(productCategoryDao.addCategory(catId,catName,catType) >= 1){
            return "Item Added Successfully";
        }else{
            return "Something went wrong !pls check the details again";
        }
	}
	
	 @RequestMapping(value="/deletecat/{cid}",method = RequestMethod.GET)
		public String productDelete(@PathVariable int cid) {
			int a;
			a=productCategoryDao.deleteCategory(cid);
			if(a==1)
			return "Delete Successfull";
			else
			return "Delete unsuccessful";
			
		}
	 @RequestMapping("/updatecategory/{catId}/{catName}/{catType}")
	// @ResponseBody
	 public String catUpdate( @PathVariable int catId,@PathVariable String catName,@PathVariable String catType)
	 {
		 int a;
	 a=productCategoryDao.updateCheck(catId);
		 if(a==1)
		 {
			 if(productCategoryDao.update(catId,catName,catType) >=1) {
				 return "Category Updated SuccessfuLly";
			 }else {
				 return "Category Updated unsuccessfully";
			 }
	 }else {
			 return "catId Not Found";
		 }
	 }
}
