package com.icg.dto;

import java.util.List;

public class CrewStr {

	private List<Crew> crewList;
	private List<List<String>> crewStrList;
	public List<Crew> getCrewList() {
		return crewList;
	}
	public void setCrewList(List<Crew> crewList) {
		this.crewList = crewList;
	}
	public List<List<String>> getCrewStrList() {
		return crewStrList;
	}
	public void setCrewStrList(List<List<String>> crewStrList) {
		this.crewStrList = crewStrList;
	}
	@Override
	public String toString() {
		return "CrewStr [crewList=" + crewList + ", crewStrList=" + crewStrList + "]";
	}
	
	
	
}
