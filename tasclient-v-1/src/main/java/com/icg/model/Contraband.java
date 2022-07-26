package com.icg.model;

import java.util.List;

public class Contraband {

	private String threatTypeName;
	private String inputId;
	private String dateRecpt;
	private String origntrName;
	private String timeOfPos;
	private String timeOfActivation;
	private String gradingName;
	private String gpslattitudeDec;
	private String gpslongitudeDec;
	private String gpslattitudeDeg;
	private String gpslongitudeDeg;
	private String distanceKmLnd;
	private String distanceMileLnd;
	private String location;
	private String regionName;
	private String coastStatName;
	private String IMEINo;
	private List<Contact> contactList;
	private String nameSuspects;
	private String sharedWithName;
	
	private String icgUnitsName;
	private String typeOfContra;
	private String quantity;
	private String units;
	private String weight;
	private String worth;
	private String caseHandedTo;
	private String jointOperWith;
	private String applattitudeDec;
	private String applongitudeDec;
	private String applattitudeDeg;
	private String applongitudeDeg;
	/*private List<Boat> boatList;
	private List<Vessel> vesselList;
	private List<Crew> crewList;*/
	private String otherInfo;
	private String followUp;
	
	
	public String getThreatTypeName() {
		return threatTypeName;
	}
	public void setThreatTypeName(String threatTypeName) {
		this.threatTypeName = threatTypeName;
	}
	public String getInputId() {
		return inputId;
	}
	public void setInputId(String inputId) {
		this.inputId = inputId;
	}
	public String getDateRecpt() {
		return dateRecpt;
	}
	public void setDateRecpt(String dateRecpt) {
		this.dateRecpt = dateRecpt;
	}
	public String getOrigntrName() {
		return origntrName;
	}
	public void setOrigntrName(String origntrName) {
		this.origntrName = origntrName;
	}
	public String getTimeOfPos() {
		return timeOfPos;
	}
	public void setTimeOfPos(String timeOfPos) {
		this.timeOfPos = timeOfPos;
	}
	public String getTimeOfActivation() {
		return timeOfActivation;
	}
	public void setTimeOfActivation(String timeOfActivation) {
		this.timeOfActivation = timeOfActivation;
	}
	public String getGradingName() {
		return gradingName;
	}
	public void setGradingName(String gradingName) {
		this.gradingName = gradingName;
	}
	public String getGpslattitudeDec() {
		return gpslattitudeDec;
	}
	public void setGpslattitudeDec(String gpslattitudeDec) {
		this.gpslattitudeDec = gpslattitudeDec;
	}
	public String getGpslongitudeDec() {
		return gpslongitudeDec;
	}
	public void setGpslongitudeDec(String gpslongitudeDec) {
		this.gpslongitudeDec = gpslongitudeDec;
	}
	public String getGpslattitudeDeg() {
		return gpslattitudeDeg;
	}
	public void setGpslattitudeDeg(String gpslattitudeDeg) {
		this.gpslattitudeDeg = gpslattitudeDeg;
	}
	public String getGpslongitudeDeg() {
		return gpslongitudeDeg;
	}
	public void setGpslongitudeDeg(String gpslongitudeDeg) {
		this.gpslongitudeDeg = gpslongitudeDeg;
	}
	public String getDistanceKmLnd() {
		return distanceKmLnd;
	}
	public void setDistanceKmLnd(String distanceKmLnd) {
		this.distanceKmLnd = distanceKmLnd;
	}
	public String getDistanceMileLnd() {
		return distanceMileLnd;
	}
	public void setDistanceMileLnd(String distanceMileLnd) {
		this.distanceMileLnd = distanceMileLnd;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getCoastStatName() {
		return coastStatName;
	}
	public void setCoastStatName(String coastStatName) {
		this.coastStatName = coastStatName;
	}
	public String getIMEINo() {
		return IMEINo;
	}
	public void setIMEINo(String iMEINo) {
		IMEINo = iMEINo;
	}
	public List<Contact> getContactList() {
		return contactList;
	}
	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	public String getNameSuspects() {
		return nameSuspects;
	}
	public void setNameSuspects(String nameSuspects) {
		this.nameSuspects = nameSuspects;
	}
	public String getSharedWithName() {
		return sharedWithName;
	}
	public void setSharedWithName(String sharedWithName) {
		this.sharedWithName = sharedWithName;
	}
	public String getIcgUnitsName() {
		return icgUnitsName;
	}
	public void setIcgUnitsName(String icgUnitsName) {
		this.icgUnitsName = icgUnitsName;
	}
	public String getTypeOfContra() {
		return typeOfContra;
	}
	public void setTypeOfContra(String typeOfContra) {
		this.typeOfContra = typeOfContra;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWorth() {
		return worth;
	}
	public void setWorth(String worth) {
		this.worth = worth;
	}
	public String getCaseHandedTo() {
		return caseHandedTo;
	}
	public void setCaseHandedTo(String caseHandedTo) {
		this.caseHandedTo = caseHandedTo;
	}
	public String getJointOperWith() {
		return jointOperWith;
	}
	public void setJointOperWith(String jointOperWith) {
		this.jointOperWith = jointOperWith;
	}
	public String getApplattitudeDec() {
		return applattitudeDec;
	}
	public void setApplattitudeDec(String applattitudeDec) {
		this.applattitudeDec = applattitudeDec;
	}
	public String getApplongitudeDec() {
		return applongitudeDec;
	}
	public void setApplongitudeDec(String applongitudeDec) {
		this.applongitudeDec = applongitudeDec;
	}
	public String getApplattitudeDeg() {
		return applattitudeDeg;
	}
	public void setApplattitudeDeg(String applattitudeDeg) {
		this.applattitudeDeg = applattitudeDeg;
	}
	public String getApplongitudeDeg() {
		return applongitudeDeg;
	}
	public void setApplongitudeDeg(String applongitudeDeg) {
		this.applongitudeDeg = applongitudeDeg;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	public String getFollowUp() {
		return followUp;
	}
	public void setFollowUp(String followUp) {
		this.followUp = followUp;
	}
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	@Override
	public String toString() {
		return "Contraband [threatTypeName=" + threatTypeName + ", inputId=" + inputId + ", dateRecpt=" + dateRecpt
				+ ", origntrName=" + origntrName + ", timeOfPos=" + timeOfPos + ", timeOfActivation=" + timeOfActivation
				+ ", gradingName=" + gradingName + ", gpslattitudeDec=" + gpslattitudeDec + ", gpslongitudeDec="
				+ gpslongitudeDec + ", gpslattitudeDeg=" + gpslattitudeDeg + ", gpslongitudeDeg=" + gpslongitudeDeg
				+ ", distanceKmLnd=" + distanceKmLnd + ", distanceMileLnd=" + distanceMileLnd + ", location=" + location
				+ ", regionName=" + regionName + ", coastStatName=" + coastStatName + ", IMEINo=" + IMEINo
				+ ", contactList=" + contactList + ", nameSuspects=" + nameSuspects + ", sharedWithName="
				+ sharedWithName + ", icgUnitsName=" + icgUnitsName + ", typeOfContra=" + typeOfContra + ", quantity="
				+ quantity + ", units=" + units + ", weight=" + weight + ", worth=" + worth + ", caseHandedTo="
				+ caseHandedTo + ", jointOperWith=" + jointOperWith + ", applattitudeDec=" + applattitudeDec
				+ ", applongitudeDec=" + applongitudeDec + ", applattitudeDeg=" + applattitudeDeg + ", applongitudeDeg="
				+ applongitudeDeg + ", otherInfo=" + otherInfo + ", followUp=" + followUp + "]";
	}

	
	
	
	
}
