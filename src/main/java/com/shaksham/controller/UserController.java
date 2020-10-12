package com.shaksham.controller;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shaksham.dao.UserDao;
import com.shaksham.model.User;
import com.shaksham.model.UserRequest;
import com.shaksham.model.UserResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
	
	
	@RestController
	public class UserController {
		
		@Autowired
		UserDao loginDao;
		
		/*
		 * Author:Rohan 
		 */
		@PostMapping("user")
		public User login(@RequestParam("username") String username, @RequestParam("password") String password) {
			
			String token = getJWTToken(username);
			User user = new User();
			
			try {
				user = loginDao.validateUserCredential(username, password);
				user.setToken(token);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return user;
			 
		}
		
		/*
		 * Author:Rohan 
		 */
		 @PostMapping(path= "/register", consumes = "application/json")
		 public UserResponse registerCustomer(@RequestBody UserRequest inputPayload) {
			 UserResponse registeredUser = new UserResponse();
			 
			 int result = 0;
			try {
				result = loginDao.registerUser(inputPayload);
			} catch (Exception e) {
				 registeredUser.setEmail(null);
				 registeredUser.setStatus(null);
				 registeredUser.setSatusCode(null);
				e.printStackTrace();
			}
			 
			 if(result == 1) {
				 registeredUser.setEmail(inputPayload.getUsername());
				 registeredUser.setStatus("registered");
				 registeredUser.setSatusCode("200");
			 }
			 
			 return registeredUser;
		 }
		
		/*
		 * Author:Rohan 
		 */
		 @GetMapping("/getusername/{email}")
		 public User getUsername(@PathVariable String email) {
			 User username = new User();
			 username = loginDao.getUsername(email);
			 return username;
		 }
		
		 @PutMapping("/resetPassword/username")
		 public String resetPassword(@PathVariable String username, @RequestBody UserRequest password){
			
			 //will add my code
			 
			 return username;
			 
		 }
		

		private String getJWTToken(String username) {
			String secretKey = "mySecretKey";
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_USER");
			
			String token = Jwts
					.builder()
					.setId("softtekJWT")
					.setSubject(username)
					.claim("authorities",
							grantedAuthorities.stream()
									.map(GrantedAuthority::getAuthority)
									.collect(Collectors.toList()))
					.setIssuedAt(new Date(System.currentTimeMillis()))
					//expiry of the token in milliseconds
					.setExpiration(new Date(System.currentTimeMillis() + 600000))
					.signWith(SignatureAlgorithm.HS512,
							secretKey.getBytes()).compact();

			return "Bearer " + token;
		}

}
