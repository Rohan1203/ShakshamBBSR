package com.shaksham.controller;

import java.math.BigInteger;
import java.security.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shaksham.dao.ShgCrudDao;
import com.shaksham.model.Shg;



@RestController
@RequestMapping("/shg")
@ComponentScan("com.example.EcomHandcrafting.controller")

/*
 * author-Preeti098
 */
public class ShgCrudController<INT> {
	
	@Autowired
	ShgCrudDao shgDao;
	
	@GetMapping("/add")
	public String welcome() {
		return "Welcome to ShakSham";
	}
	
	@RequestMapping(value="/addshg/{shgId}/{shgName}/{address}/{blockName}/{district}/{state}/{pincode}/"
			+ "{mobileNumber}/{noOfMember}/{aadharNumber}/{accountNumber}/{ifscCode}/{shgEmail}")
	@ResponseBody
	public String addshg(@PathVariable String shgId,@PathVariable String shgName,@PathVariable String address,@PathVariable String blockName,@PathVariable String district,
			@PathVariable String state,@PathVariable INT pincode,@PathVariable BigInteger mobileNumber,@PathVariable INT noOfMember,
			@PathVariable BigInteger aadharNumber,@PathVariable BigInteger accountNumber,@PathVariable String ifscCode,
			@PathVariable String shgEmail) {
				
		if(shgDao.addShg(shgId,shgName,address,blockName,district,state,pincode,mobileNumber,
				noOfMember,aadharNumber,accountNumber,ifscCode,shgEmail)>=1) {
			 return "Shg Addition request sent Successfully.You will receive a conformation email soon";
        }else{
            return "Unsuccessfull!!!Something went wrong !pls check the details again";
        }
			
		}
	
	
	/*
	 * Author Supriya
	 */
	@RequestMapping(value="/shgdelete/{sid}",method = RequestMethod.GET)
	public String shgDelete(@PathVariable String sid) {
		int a;
		a=shgDao.deleteShg(sid);
		if(a==1)
		return "Delete Successfull";
		else
		return "Delete unsuccessful";
		
	}
	
	/*
	 * Author Puspa 
	 *
	 */
	@GetMapping(path= "/shgrequests")
	public List<Shg> allShg(){
		return shgDao.getAllRequests();
	}
	
	
	
	@GetMapping(value="/verifySHG/{shgId}")
	public String verifyShg(@PathVariable String shgId) {
		String result = shgDao.verifySHG(shgId);
			
			return result;
	}
	
	@PutMapping("/updateshg/{shgId}")
	public String updateshg(@PathVariable String shgId,@RequestBody Shg shg) {
		
		String result = "failure";
		Shg currentShg = shgDao.findById(shgId);
		if(currentShg == null) {
			return result;
			
		}
		else {
			System.out.print("if working");
			return result = shgDao.UpdateShg(shg);
		}
	}

}
