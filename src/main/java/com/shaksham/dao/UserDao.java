package com.shaksham.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.shaksham.model.User;



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
}
