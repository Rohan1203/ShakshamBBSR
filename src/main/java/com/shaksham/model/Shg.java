package com.shaksham.model;

import java.math.BigInteger;
import java.security.Timestamp;

import org.springframework.stereotype.Component;
@Component
public class Shg {
	
	private String shgId;
	private String shgName;
	private String address;
	private String blockName;
	private String district;
	private String state;
	private int pincode;
	private BigInteger mobileNumber;
	private int noOfMember;
	private BigInteger aadharNumber;
	private BigInteger accountNumber;
	private String ifscCode;
	private String date;
	private String currentStatus;
	private String shgEmail;
	
	public Shg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shg(String shgId, String shgName, String address, String blockName, String district, String state,
			int pincode, BigInteger mobileNumber, int noOfMember, BigInteger aadharNumber, BigInteger accountNumber,
			String ifscCode, String date, String currentStatus, String shgEmail) {
		super();
		this.shgId = shgId;
		this.shgName = shgName;
		this.address = address;
		this.blockName = blockName;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.mobileNumber = mobileNumber;
		this.noOfMember = noOfMember;
		this.aadharNumber = aadharNumber;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.date = date;
		this.currentStatus = currentStatus;
		this.shgEmail = shgEmail;
	}
	public String getShgId() {
		return shgId;
	}
	public void setShgId(String shgId) {
		this.shgId = shgId;
	}
	public String getShgName() {
		return shgName;
	}
	public void setShgName(String shgName) {
		this.shgName = shgName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public BigInteger getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getNoOfMember() {
		return noOfMember;
	}
	public void setNoOfMember(int noOfMember) {
		this.noOfMember = noOfMember;
	}
	public BigInteger getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(BigInteger aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public BigInteger getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(BigInteger accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getShgEmail() {
		return shgEmail;
	}
	public void setShgEmail(String shgEmail) {
		this.shgEmail = shgEmail;
	}
	
	
}
	
	


/*create table shg(
shgName varchar(40),
shgId varchar(40),
address varchar(40),
blockName varchar(40),
district varchar(40),
state varchar(40),
pincode int,
mobileNumber bigint,
noOfMember int,
aadharNumber bigint,
accountNumber bigint,
ifscCode varchar(40),
registrationDate date default (date(current_timestamp)),
currentStatus varchar(10)
);*/
 