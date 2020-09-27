package com.shaksham.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.shaksham.model.Shg;
import com.shaksham.model.User;

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
	
	/*
	 * Author Puspa
	 */
	
	public String verifySHG(String shgId) {
		  String sql = "select shgId from govt_shg where shgId = ?";
	        Shg result = jdbcTemplate.queryForObject(sql, new Object[]{shgId}, BeanPropertyRowMapper.newInstance(Shg.class));  
	        String id = result.getShgId();
	        
	        final String fromEmail = "ecom.shaksham@gmail.com"; //requires valid gmail id
	        final String password = "shaksham@shg"; // correct password for gmail id
	        final String toEmail = "170301120138@cutm.ac.in"; // can be any email id in which user will get OTP

	        Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
	        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
	        props.put("mail.smtp.port", "587"); //SMTP Port
	        props.setProperty("mail.smtp.starttls.enable", "true");

	        Authenticator auth = new Authenticator() {
	            //override the getPasswordAuthentication method
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(fromEmail, password);
	            }
	        };

	        Session session = Session.getInstance(props, auth); // create a SMTP session


	        try {
	            MimeMessage msg = new MimeMessage(session);
	            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	            msg.setSubject("Acknowledgement of Registration", "UTF-8");

	            msg.setSentDate(new Date());
	            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	          
	            MimeBodyPart messageBodyPart = new MimeBodyPart();
	            
	            messageBodyPart.setContent("Welcome"+"Dear Madam/Sir,"
	            		+ "Your new Shaksham Account has been created. Welcome to the Shaksham community."
	            		+"From now on,start your teading by logging in through your email address and your password"+""
	            				+ "Email :" + toEmail
	            				+ "Password : Das@Puspa","text/html");
	            Multipart multipart = new MimeMultipart();
	            multipart.addBodyPart(messageBodyPart);
	           

	            
	            
	            msg.setContent(multipart);
	            Transport.send(msg);  
	            System.out.println("Email Sent Successfully!!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        if(shgId.equals(id)) {
	        	return "Approved";
	        }
	        else {
	        	return "Declined";
	        }
	}

}
