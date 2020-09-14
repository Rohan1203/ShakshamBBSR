package com.example.shaksham.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.shaksham.model.Shg;

@Repository
public class ShgCrudDao<INT> {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Shg> getAllRequests() {
		List<Shg> shg = new ArrayList<Shg>();
		String sql = "select * from shg where currentStatus='new';";
		shg = jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Shg.class));
		return shg;
	}
	/*
	 * author-Preeti098
	 */
	public int addShg(String shgId, String shgName, String address, String blockName, String district, String state,
			INT pincode, BigInteger mobileNumber, INT noOfMember, BigInteger aadharNumber, BigInteger accountNumber,
			String ifscCode,String currentStatus) {
		
		String query = "INSERT INTO shg(shgId,shgName,address,blockName,district,state,pincode,mobileNumber,noOfMember,aadharNumber,accountNumber,ifscCode,date,currentStatus) "
				+ "    Values=(?,?,?,?,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP,?);";
		return jdbcTemplate.update(query,new Object[] {shgId,shgName,address,blockName,district,state,pincode,mobileNumber,
						noOfMember,aadharNumber,accountNumber,ifscCode,currentStatus});	
	}

}
