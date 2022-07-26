package com.icg.dto;

import java.util.List;

public class AmmunitionStr {

	private List<Ammunition> ammunitionList;
	private List<List<String>> ammunitionStrList;
	
	public List<Ammunition> getAmmunitionList() {
		return ammunitionList;
	}
	public void setAmmunitionList(List<Ammunition> ammunitionList) {
		this.ammunitionList = ammunitionList;
	}
	public List<List<String>> getAmmunitionStrList() {
		return ammunitionStrList;
	}
	public void setAmmunitionStrList(List<List<String>> ammunitionStrList) {
		this.ammunitionStrList = ammunitionStrList;
	}
	@Override
	public String toString() {
		return "AmmunitionStr [ammunitionList=" + ammunitionList + ", ammunitionStrList=" + ammunitionStrList + "]";
	}
	
}
