package com.icg.dto;

public class ThreatHistoryBean {
// genDtlsId,inputId,originator,latitute,longitute,timeOfActivation,imeiNo,distanceFromLand,region,	
	private String genDtlsId;
	private String inputId;
	private String originator;
	private String latitute;
	private String longitute;
	private String timeOfActivation;
	private String imeiNo;
	private String distanceFromLand;
	private String region;
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
	public String getTimeOfActivation() {
		return timeOfActivation;
	}
	public void setTimeOfActivation(String timeOfActivation) {
		this.timeOfActivation = timeOfActivation;
	}
	public String getImeiNo() {
		return imeiNo;
	}
	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}
	public String getDistanceFromLand() {
		return distanceFromLand;
	}
	public void setDistanceFromLand(String distanceFromLand) {
		this.distanceFromLand = distanceFromLand;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	
	
	public String getTypeOfThreatId() {
		return typeOfThreatId;
	}
	public void setTypeOfThreatId(String typeOfThreatId) {
		this.typeOfThreatId = typeOfThreatId;
	}
	@Override
	public String toString() {
		return "ThreatHistoryBean [genDtlsId=" + genDtlsId + ", inputId=" + inputId + ", originator=" + originator
				+ ", latitute=" + latitute + ", longitute=" + longitute + ", timeOfActivation=" + timeOfActivation
				+ ", imeiNo=" + imeiNo + ", distanceFromLand=" + distanceFromLand + ", region=" + region
				+ ", typeOfThreatId=" + typeOfThreatId + "]";
	}
	
	
	
	
	
	
	

}
