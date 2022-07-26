package com.icg.dto;

public class Contact {

	private String cntctId;
	private String contactNo;
	private String country;
	private String gnCountryCode;
	
	
	
	public String getGnCountryCode() {
		return gnCountryCode;
	}
	public void setGnCountryCode(String gnCountryCode) {
		this.gnCountryCode = gnCountryCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getCntctId() {
		return cntctId;
	}
	public void setCntctId(String cntctId) {
		this.cntctId = cntctId;
	}
	@Override
	public String toString() {
		return "Contact [cntctId=" + cntctId + ", contactNo=" + contactNo + ", country=" + country + ", gnCountryCode="
				+ gnCountryCode + "]";
	}

	
	
	
}
