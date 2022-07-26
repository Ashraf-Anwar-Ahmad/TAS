package com.icg.dto;

import java.util.List;

public class VesselStr {

	private List<Vessel> vesselList;
	private List<List<String>> vesselStrList;
	public List<Vessel> getVesselList() {
		return vesselList;
	}
	public void setVesselList(List<Vessel> vesselList) {
		this.vesselList = vesselList;
	}
	public List<List<String>> getVesselStrList() {
		return vesselStrList;
	}
	public void setVesselStrList(List<List<String>> vesselStrList) {
		this.vesselStrList = vesselStrList;
	}
	@Override
	public String toString() {
		return "VesselStr [vesselList=" + vesselList + ", vesselStrList=" + vesselStrList + "]";
	}
	
	
	
}
