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
			String ifscCode,String shgEmail) {
		
		String query ="INSERT INTO shg(shgId,shgName,address,blockName,district,state,pincode,mobileNumber,noOfMember,aadharNumber,accountNumber,ifscCode,date,currentStatus,shgEmail) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP,default,?);";
		return jdbcTemplate.update(query,new Object[] {shgId,shgName,address,blockName,district,state,pincode,mobileNumber,
						noOfMember,aadharNumber,accountNumber,ifscCode,shgEmail});	
	}
	
	/*
	 * Author Supriya
	 */
	public int deleteShg(String shgId)
	{
		Shg s = new Shg(); 
        s.setShgId(shgId);
		String sql = "delete from shg where shgId = ?;";
		return jdbcTemplate.update(sql, new Object[] {s.getShgId()});
	      
	      
	}

}
