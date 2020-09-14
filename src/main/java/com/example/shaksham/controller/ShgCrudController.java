package com.example.shaksham.controller;

import java.math.BigInteger;
import java.security.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.shaksham.dao.ShgCrudDao;



@RestController
@RequestMapping("/shg")
@ComponentScan("com.example.EcomHandcrafting.controller")

/*
 * author-Preeti098
 */
public class ShgCrudController<INT> {
	
	@Autowired
	ShgCrudDao shg;
	
	@GetMapping("/add")
	public String welcome() {
		return "Welcome to ShakSham";
	}
	
	@RequestMapping(value="/addshg/{shgId}/{shgName}/{address}/{blockName}/{district}/{state}/{pincode}/"
			+ "{mobileNumber}/{noOfMember}/{aadharNumber}/{accountNumber}/{ifscCode}/{currentStatus}",method=RequestMethod.POST)
	@ResponseBody
	public String addshg(@PathVariable String shgId,@PathVariable String shgName,@PathVariable String address,@PathVariable String blockName,@PathVariable String district,
			@PathVariable String state,@PathVariable INT pincode,@PathVariable BigInteger mobileNumber,@PathVariable INT noOfMember,
			@PathVariable BigInteger aadharNumber,@PathVariable BigInteger accountNumber,@PathVariable String ifscCode,
			@PathVariable String currentStatus) {
				
		if(shg.addShg(shgId,shgName,address,blockName,district,state,pincode,mobileNumber,
				noOfMember,aadharNumber,accountNumber,ifscCode,currentStatus)>=1) {
			 return "Shg Addition request sent Successfully.You will receive a conformation email soon";
        }else{
            return "Unsuccessfull!!!Something went wrong !pls check the details again";
        }
			
		}
	

}
