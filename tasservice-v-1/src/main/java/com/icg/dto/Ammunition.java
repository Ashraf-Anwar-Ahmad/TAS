package com.icg.dto;

public class Ammunition {

	private String ammunId;
	private String typeAmmun;
	private String ammunQty;
	private String ammunMake;
	private String ammunModel;
	private String ammunManuCntry;
	private String ammunRmks;
	private String armsDetails;
	private String ammdetails;
	private String ammuUnit;
	private String ammuUnitName;
	public String getAmmunId() {
		return ammunId;
	}
	public void setAmmunId(String ammunId) {
		this.ammunId = ammunId;
	}
	public String getTypeAmmun() {
		return typeAmmun;
	}
	public void setTypeAmmun(String typeAmmun) {
		this.typeAmmun = typeAmmun;
	}
	public String getAmmunQty() {
		return ammunQty;
	}
	public void setAmmunQty(String ammunQty) {
		this.ammunQty = ammunQty;
	}
	public String getAmmunMake() {
		return ammunMake;
	}
	public void setAmmunMake(String ammunMake) {
		this.ammunMake = ammunMake;
	}
	public String getAmmunModel() {
		return ammunModel;
	}
	public void setAmmunModel(String ammunModel) {
		this.ammunModel = ammunModel;
	}
	public String getAmmunManuCntry() {
		return ammunManuCntry;
	}
	public void setAmmunManuCntry(String ammunManuCntry) {
		this.ammunManuCntry = ammunManuCntry;
	}
	public String getAmmunRmks() {
		return ammunRmks;
	}
	public void setAmmunRmks(String ammunRmks) {
		this.ammunRmks = ammunRmks;
	}
	public String getArmsDetails() {
		return armsDetails;
	}
	public void setArmsDetails(String armsDetails) {
		this.armsDetails = armsDetails;
	}
	public String getAmmdetails() {
		return ammdetails;
	}
	public void setAmmdetails(String ammdetails) {
		this.ammdetails = ammdetails;
	}
	public String getAmmuUnit() {
		return ammuUnit;
	}
	public void setAmmuUnit(String ammuUnit) {
		this.ammuUnit = ammuUnit;
	}
	
	public String getAmmuUnitName() {
		return ammuUnitName;
	}
	public void setAmmuUnitName(String ammuUnitName) {
		this.ammuUnitName = ammuUnitName;
	}
	@Override
	public String toString() {
		return "Ammunition [ammunId=" + ammunId + ", typeAmmun=" + typeAmmun + ", ammunQty=" + ammunQty + ", ammunMake="
				+ ammunMake + ", ammunModel=" + ammunModel + ", ammunManuCntry=" + ammunManuCntry + ", ammunRmks="
				+ ammunRmks + ", armsDetails=" + armsDetails + ", ammdetails=" + ammdetails + ", ammuUnit=" + ammuUnit
				+ ", ammuUnitName=" + ammuUnitName + "]";
	}
}
