package com.shaksham.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.shaksham.model.User;
import com.shaksham.model.UserRequest;
import com.shaksham.model.UserResponse;



@Repository
public class UserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	

	User login = new User();

	

	public User validateUserCredential(String username, String password) {  
        String sql = "select username, type from login where username = ? and password = ?";
        User result = jdbcTemplate.queryForObject(sql, new Object[]{username, password}, BeanPropertyRowMapper.newInstance(User.class));  
               
        return result;
	}



	public int registerUser(UserRequest inputPayload) {
		String sql = "insert into login(username, password, type) values(?, ?, ?)";
        int result = jdbcTemplate.update(sql, new Object[]{inputPayload.getUsername(), inputPayload.getPassword(), inputPayload.getType()});  
        
        return result;
	}



	public User getUsername(String email) {
		String sql = "select username from login where username=?";
        User result = jdbcTemplate.queryForObject(sql, new Object[]{email}, BeanPropertyRowMapper.newInstance(User.class));  
        
		return result;
	}
}
