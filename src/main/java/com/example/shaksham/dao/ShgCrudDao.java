package com.example.shaksham.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.shaksham.model.Shg;

@Repository
public class ShgCrudDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Shg> getAllRequests() {
		List<Shg> shg = new ArrayList<Shg>();
		String sql = "select * from shg where currentStatus='new';";
		shg = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Shg.class));
		return shg;
	}

}
