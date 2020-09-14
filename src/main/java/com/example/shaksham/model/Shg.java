package com.example.shaksham.model;

public class Shg {
	
	private String shgName;
	private String shgId;
//	private String email;
	private String address;
	private String blockName;
	private String district;
	private String state;
	private String pincode;
	private String contactNumber;
	private String noOfMember;
	private String aadharNumber;
	private String accountNumber;
	private String ifscCode;
	private String registrationDate;
	private String currentStatus;
	
	public Shg() {
	}

	public Shg(String shgName, String shgId, String address, String blockName, String district, String state,
			String pincode, String contactNumber, String noOfMember, String aadharNumber, String accountNumber,
			String ifscCode, String registrationDate, String currentStatus) {
		this.shgName = shgName;
		this.shgId = shgId;
		this.address = address;
		this.blockName = blockName;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.contactNumber = contactNumber;
		this.noOfMember = noOfMember;
		this.aadharNumber = aadharNumber;
		this.accountNumber = accountNumber;
		this.ifscCode = ifscCode;
		this.registrationDate = registrationDate;
		this.currentStatus = currentStatus;
	}

	public String getShgName() {
		return shgName;
	}

	public void setShgName(String shgName) {
		this.shgName = shgName;
	}

	public String getShgId() {
		return shgId;
	}

	public void setShgId(String shgId) {
		this.shgId = shgId;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getNoOfMember() {
		return noOfMember;
	}

	public void setNoOfMember(String noOfMember) {
		this.noOfMember = noOfMember;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	
}
