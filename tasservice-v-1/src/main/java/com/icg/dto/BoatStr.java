package com.icg.dto;

import java.util.List;

public class BoatStr {

	private List<Boat> boatList;
	private List<List<String>> boatStrList;
	
	
	
	public List<Boat> getBoatList() {
		return boatList;
	}



	public void setBoatList(List<Boat> boatList) {
		this.boatList = boatList;
	}



	public List<List<String>> getBoatStrList() {
		return boatStrList;
	}



	public void setBoatStrList(List<List<String>> boatStrList) {
		this.boatStrList = boatStrList;
	}



	@Override
	public String toString() {
		return "BoatStr [boatList=" + boatList + ", boatStrList=" + boatStrList + "]";
	}
	
	
	
}
