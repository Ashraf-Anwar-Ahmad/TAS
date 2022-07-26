package com.icg.model;

import java.util.List;

public class ViewMapBean {
	private List<String> longitude;
	private List<String> lattitude;
	private List<String> locationName;
	
	private List<String> threatType;

	public List<String> getLongitude() {
		return longitude;
	}

	public void setLongitude(List<String> longitude) {
		this.longitude = longitude;
	}

	public List<String> getLattitude() {
		return lattitude;
	}

	public void setLattitude(List<String> lattitude) {
		this.lattitude = lattitude;
	}

	public List<String> getLocationName() {
		return locationName;
	}

	public void setLocationName(List<String> locationName) {
		this.locationName = locationName;
	}

	public List<String> getThreatType() {
		return threatType;
	}

	public void setThreatType(List<String> threatType) {
		this.threatType = threatType;
	}

	@Override
	public String toString() {
		return "ViewMapBean [longitude=" + longitude + ", lattitude=" + lattitude + ", locationName=" + locationName
				+ ", threatType=" + threatType + "]";
	}
	
}
