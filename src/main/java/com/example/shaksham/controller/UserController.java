package com.example.shaksham.controller;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shaksham.dao.UserDao;
import com.example.shaksham.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


//@RestController
//@RequestMapping("/user")
//public class UserController {
//	
//	@Autowired
//	UserDao loginDao;
//	
//	@GetMapping()
//	public String wecomeMessage() {
//		return "Welcome to Shaksham";
//	}
//	
//	/**
//	 * 
//	 * @param username
//	 * @param password
//	 * @return object of login
//	 */
//	@RequestMapping(value = "/login/{username}/{password}", method = RequestMethod.GET)
//	public User userLogin(@PathVariable String username, @PathVariable String password) {
//		User login;
//		
//		login = loginDao.validateUserCredential(username, password);
//		
//		return login;
//	}
	
	
	@RestController
	public class UserController {
		
		@Autowired
		UserDao loginDao;

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
			
//			user.setUsername(username);
//			user.setPassword(password);
			return user;
			 
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
