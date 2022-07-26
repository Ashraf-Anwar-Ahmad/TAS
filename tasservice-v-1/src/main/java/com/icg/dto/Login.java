package com.icg.dto;

public class Login {
	
	private String userName;	
	private String orgUnit;
	private String orgUnitId;
	private String pId;
	
	
	public String getOrgUnitId() {
		return orgUnitId;
	}
	public void setOrgUnitId(String orgUnitId) {
		this.orgUnitId = orgUnitId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOrgUnit() {
		return orgUnit;
	}
	public void setOrgUnit(String orgUnit) {
		this.orgUnit = orgUnit;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	@Override
	public String toString() {
		return "Login [userName=" + userName + ", orgUnit=" + orgUnit + ", orgUnitId=" + orgUnitId + ", pId=" + pId
				+ "]";
	}
	
	
	
}
