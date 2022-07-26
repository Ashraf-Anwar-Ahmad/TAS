package com.icg.model;

public class Narcotic {

	private String narcoId;
	private String narcoTypeId;
	private String narcoTypeName;
	private String narcoQty;
	private String narcoUnit;
	private String narcoUnitDescr;
	public String getNarcoId() {
		return narcoId;
	}
	public void setNarcoId(String narcoId) {
		this.narcoId = narcoId;
	}
	public String getNarcoTypeId() {
		return narcoTypeId;
	}
	public void setNarcoTypeId(String narcoTypeId) {
		this.narcoTypeId = narcoTypeId;
	}
	public String getNarcoTypeName() {
		return narcoTypeName;
	}
	public void setNarcoTypeName(String narcoTypeName) {
		this.narcoTypeName = narcoTypeName;
	}
	public String getNarcoQty() {
		return narcoQty;
	}
	public void setNarcoQty(String narcoQty) {
		this.narcoQty = narcoQty;
	}
	
	public String getNarcoUnit() {
		return narcoUnit;
	}
	public void setNarcoUnit(String narcoUnit) {
		this.narcoUnit = narcoUnit;
	}
	
	public String getNarcoUnitDescr() {
		return narcoUnitDescr;
	}
	public void setNarcoUnitDescr(String narcoUnitDescr) {
		this.narcoUnitDescr = narcoUnitDescr;
	}
	@Override
	public String toString() {
		return "Narcotic [narcoId=" + narcoId + ", narcoTypeId=" + narcoTypeId + ", narcoTypeName=" + narcoTypeName
				+ ", narcoQty=" + narcoQty + ", narcoUnit=" + narcoUnit + ", narcoUnitDescr=" + narcoUnitDescr + "]";
	}
		
}
