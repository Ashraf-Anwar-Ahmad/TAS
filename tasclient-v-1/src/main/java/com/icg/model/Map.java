package com.icg.model;

public class Map {
	private String longitude;
	private String lattitude;
	private String locationName;
	
	private String threatType;
	
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLattitude() {
		return lattitude;
	}
	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getThreatType() {
		return threatType;
	}
	public void setThreatType(String threatType) {
		this.threatType = threatType;
	}
	@Override
	public String toString() {
		return "Map [longitude=" + longitude + ", lattitude=" + lattitude + ", locationName=" + locationName
				+ ", threatType=" + threatType + "]";
	}
	
	
}