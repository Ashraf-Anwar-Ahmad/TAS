package com.icg.dto;

import java.util.List;

public class ThreatCheck {

	private String thrtimeiNo;
	private List<Contact> contactList;
	private String thrtgpsLong;
	private String thrtgpsLat;
	private String thrtSusNam;
	private List<Boat> boatList;
	private List<Vessel> vesselList;
	public String getThrtimeiNo() {
		return thrtimeiNo;
	}
	public void setThrtimeiNo(String thrtimeiNo) {
		this.thrtimeiNo = thrtimeiNo;
	}
	public List<Contact> getContactList() {
		return contactList;
	}
	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	public String getThrtgpsLong() {
		return thrtgpsLong;
	}
	public void setThrtgpsLong(String thrtgpsLong) {
		this.thrtgpsLong = thrtgpsLong;
	}
	public String getThrtgpsLat() {
		return thrtgpsLat;
	}
	public void setThrtgpsLat(String thrtgpsLat) {
		this.thrtgpsLat = thrtgpsLat;
	}
	public String getThrtSusNam() {
		return thrtSusNam;
	}
	public void setThrtSusNam(String thrtSusNam) {
		this.thrtSusNam = thrtSusNam;
	}
	public List<Boat> getBoatList() {
		return boatList;
	}
	public void setBoatList(List<Boat> boatList) {
		this.boatList = boatList;
	}
	public List<Vessel> getVesselList() {
		return vesselList;
	}
	public void setVesselList(List<Vessel> vesselList) {
		this.vesselList = vesselList;
	}
	@Override
	public String toString() {
		return "ThreatCheck [thrtimeiNo=" + thrtimeiNo + ", contactList=" + contactList + ", thrtgpsLong=" + thrtgpsLong
				+ ", thrtgpsLat=" + thrtgpsLat + ", thrtSusNam=" + thrtSusNam + ", boatList=" + boatList
				+ ", vesselList=" + vesselList + "]";
	}
	
	
	
	
	
}
