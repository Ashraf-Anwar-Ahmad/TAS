package com.icg.dto;

import java.io.File;
import java.util.List;

public class CounterThreat {

	private String threatId;
	private String threatTypeId;
	private String threatTypeName;
	private String inputId;
	private String dateRecpt;
	private String origntrId;
	private String origntrName;
	private String origntrOther;
	private String timeOfPos;
	private String timeOfActivation;
	private String gradingId;
	private String gradingName;
	private String gpslattitudeDec;
	private String gpslongitudeDec;
	private String gpslattitudeDeg;
	private String gpslongitudeDeg;
	private String distanceKmLnd;
	private String distanceMileLnd;
	private String location;
	private String regionId;
	private String regionName;
	private String coastStatId;
	private String coastStatName;
	private List<Imei> imeiList;
	private List<List<String>> imeiStrList;
	private List<Contact> contactList;
	private String nameSuspects;
	private String sharedWithId;
//	private String sharedWithName;
	private String sharedWithOther;

	private String icgUnitsId;
	private List<String> icgUnitsName;
	private String applattitudeDec;
	private String applongitudeDec;
	private String applattitudeDeg;
	private String applongitudeDeg;

	private List<Boat> boatList;
	private List<List<String>> boatStrList;

	private List<Vessel> vesselList;
	private List<List<String>> vesselStrList;

	private List<Crew> crewList;
	private List<List<String>> crewStrList;

	private List<Ammunition> ammunitionList;
	private List<List<String>> ammunitionStrList;

	private String otherInfo;
	private String followUp;
	private File uploadDocs;

	private String fromWhere;// (0406)
	private String locationName;// (0406)
	private String otherUnit;

	// added 2 June 2022
	private List<String> sharedWithName;

	public List<String> getSharedWithName() {
		return sharedWithName;
	}

	public void setSharedWithName(List<String> sharedWithName) {
		this.sharedWithName = sharedWithName;
	}

	public String getThreatId() {
		return threatId;
	}

	public void setThreatId(String threatId) {
		this.threatId = threatId;
	}

	public String getThreatTypeId() {
		return threatTypeId;
	}

	public void setThreatTypeId(String threatTypeId) {
		this.threatTypeId = threatTypeId;
	}

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

	public String getOrigntrId() {
		return origntrId;
	}

	public void setOrigntrId(String origntrId) {
		this.origntrId = origntrId;
	}

	public String getOrigntrName() {
		return origntrName;
	}

	public void setOrigntrName(String origntrName) {
		this.origntrName = origntrName;
	}

	public String getOrigntrOther() {
		return origntrOther;
	}

	public void setOrigntrOther(String origntrOther) {
		this.origntrOther = origntrOther;
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

	public String getGradingId() {
		return gradingId;
	}

	public void setGradingId(String gradingId) {
		this.gradingId = gradingId;
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

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCoastStatId() {
		return coastStatId;
	}

	public void setCoastStatId(String coastStatId) {
		this.coastStatId = coastStatId;
	}

	public String getCoastStatName() {
		return coastStatName;
	}

	public void setCoastStatName(String coastStatName) {
		this.coastStatName = coastStatName;
	}

	public List<Imei> getImeiList() {
		return imeiList;
	}

	public void setImeiList(List<Imei> imeiList) {
		this.imeiList = imeiList;
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

	public String getSharedWithId() {
		return sharedWithId;
	}

	public void setSharedWithId(String sharedWithId) {
		this.sharedWithId = sharedWithId;
	}

//	public String getSharedWithName() {
//		return sharedWithName;
//	}
//	public void setSharedWithName(String sharedWithName) {
//		this.sharedWithName = sharedWithName;
//	}
	public String getSharedWithOther() {
		return sharedWithOther;
	}

	public void setSharedWithOther(String sharedWithOther) {
		this.sharedWithOther = sharedWithOther;
	}

	public String getIcgUnitsId() {
		return icgUnitsId;
	}

	public void setIcgUnitsId(String icgUnitsId) {
		this.icgUnitsId = icgUnitsId;
	}

	public List<String> getIcgUnitsName() {
		return icgUnitsName;
	}

	public void setIcgUnitsName(List<String> icgUnitsName) {
		this.icgUnitsName = icgUnitsName;
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

	public File getUploadDocs() {
		return uploadDocs;
	}

	public void setUploadDocs(File uploadDocs) {
		this.uploadDocs = uploadDocs;
	}

	public String getFromWhere() {
		return fromWhere;
	}

	public void setFromWhere(String fromWhere) {
		this.fromWhere = fromWhere;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

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

	public String getOtherUnit() {
		return otherUnit;
	}

	public void setOtherUnit(String otherUnit) {
		this.otherUnit = otherUnit;
	}

	public List<List<String>> getImeiStrList() {
		return imeiStrList;
	}

	public void setImeiStrList(List<List<String>> imeiStrList) {
		this.imeiStrList = imeiStrList;
	}

	@Override
	public String toString() {
		return "CounterThreat [threatId=" + threatId + ", threatTypeId=" + threatTypeId + ", threatTypeName="
				+ threatTypeName + ", inputId=" + inputId + ", dateRecpt=" + dateRecpt + ", origntrId=" + origntrId
				+ ", origntrName=" + origntrName + ", origntrOther=" + origntrOther + ", timeOfPos=" + timeOfPos
				+ ", timeOfActivation=" + timeOfActivation + ", gradingId=" + gradingId + ", gradingName=" + gradingName
				+ ", gpslattitudeDec=" + gpslattitudeDec + ", gpslongitudeDec=" + gpslongitudeDec + ", gpslattitudeDeg="
				+ gpslattitudeDeg + ", gpslongitudeDeg=" + gpslongitudeDeg + ", distanceKmLnd=" + distanceKmLnd
				+ ", distanceMileLnd=" + distanceMileLnd + ", location=" + location + ", regionId=" + regionId
				+ ", regionName=" + regionName + ", coastStatId=" + coastStatId + ", coastStatName=" + coastStatName
				+ ", imeiList=" + imeiList + ", imeiStrList=" + imeiStrList + ", contactList=" + contactList
				+ ", nameSuspects=" + nameSuspects + ", sharedWithId=" + sharedWithId + ", sharedWithOther="
				+ sharedWithOther + ", icgUnitsId=" + icgUnitsId + ", icgUnitsName=" + icgUnitsName
				+ ", applattitudeDec=" + applattitudeDec + ", applongitudeDec=" + applongitudeDec + ", applattitudeDeg="
				+ applattitudeDeg + ", applongitudeDeg=" + applongitudeDeg + ", boatList=" + boatList + ", boatStrList="
				+ boatStrList + ", vesselList=" + vesselList + ", vesselStrList=" + vesselStrList + ", crewList="
				+ crewList + ", crewStrList=" + crewStrList + ", ammunitionList=" + ammunitionList
				+ ", ammunitionStrList=" + ammunitionStrList + ", otherInfo=" + otherInfo + ", followUp=" + followUp
				+ ", uploadDocs=" + uploadDocs + ", fromWhere=" + fromWhere + ", locationName=" + locationName
				+ ", otherUnit=" + otherUnit + ", sharedWithName=" + sharedWithName + "]";
	}
}
