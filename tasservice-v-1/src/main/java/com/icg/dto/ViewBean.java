package com.icg.dto;

public class ViewBean {
	//genDtlsId,inputId,dateOfReceipt,originator,gpsPosition,typeOfThreat,
	
	private String genDtlsId;
	private String inputId;
	private String dateOfReceipt;
	private String originator;
	private String latitute;
	private String longitute;
	private String typeOfThreat;
	private String typeOfThreatId;
	
	
	public String getGenDtlsId() {
		return genDtlsId;
	}
	public void setGenDtlsId(String genDtlsId) {
		this.genDtlsId = genDtlsId;
	}
	public String getInputId() {
		return inputId;
	}
	public void setInputId(String inputId) {
		this.inputId = inputId;
	}
	public String getDateOfReceipt() {
		return dateOfReceipt;
	}
	public void setDateOfReceipt(String dateOfReceipt) {
		this.dateOfReceipt = dateOfReceipt;
	}
	public String getOriginator() {
		return originator;
	}
	public void setOriginator(String originator) {
		this.originator = originator;
	}
	
	public String getLatitute() {
		return latitute;
	}
	public void setLatitute(String latitute) {
		this.latitute = latitute;
	}
	public String getLongitute() {
		return longitute;
	}
	public void setLongitute(String longitute) {
		this.longitute = longitute;
	}
	public String getTypeOfThreat() {
		return typeOfThreat;
	}
	public void setTypeOfThreat(String typeOfThreat) {
		this.typeOfThreat = typeOfThreat;
	}
	
	
	public String getTypeOfThreatId() {
		return typeOfThreatId;
	}
	public void setTypeOfThreatId(String typeOfThreatId) {
		this.typeOfThreatId = typeOfThreatId;
	}
	@Override
	public String toString() {
		return "ViewBean [genDtlsId=" + genDtlsId + ", inputId=" + inputId + ", dateOfReceipt=" + dateOfReceipt
				+ ", originator=" + originator + ", latitute=" + latitute + ", longitute=" + longitute
				+ ", typeOfThreat=" + typeOfThreat + ", typeOfThreatId=" + typeOfThreatId + "]";
	}
	
}
