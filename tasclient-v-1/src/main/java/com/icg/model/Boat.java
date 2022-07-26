package com.icg.model;

public class Boat {

	private String boatId;
	private String boatName;
	private String regNum;
	private String ownerName;

	private String portReg;
	private String noOfCrew;
	private String docHeld;
	private String navEqpt;
	private String commEqpt;
	private String lifeEqpt;
	private String boatlpc;
	private String boatetd;
	private String boatnpc;
	private String boateta;
	private String licenseFish;
	private String ownerContDts;
	private String boatColrcd;
	private String remarks;
	
	//added 30 may 22 INTEK
	private String ownerContCode;
	private String stateReg;
	private String typeOfBoat;
	private String typeOfBoatName;
	
	public String getBoatId() {
		return boatId;
	}
	public void setBoatId(String boatId) {
		this.boatId = boatId;
	}
	public String getBoatName() {
		return boatName;
	}
	public void setBoatName(String boatName) {
		this.boatName = boatName;
	}
	public String getRegNum() {
		return regNum;
	}
	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getPortReg() {
		return portReg;
	}
	public void setPortReg(String portReg) {
		this.portReg = portReg;
	}
	public String getNoOfCrew() {
		return noOfCrew;
	}
	public void setNoOfCrew(String noOfCrew) {
		this.noOfCrew = noOfCrew;
	}
	public String getDocHeld() {
		return docHeld;
	}
	public void setDocHeld(String docHeld) {
		this.docHeld = docHeld;
	}
	public String getNavEqpt() {
		return navEqpt;
	}
	public void setNavEqpt(String navEqpt) {
		this.navEqpt = navEqpt;
	}
	public String getCommEqpt() {
		return commEqpt;
	}
	public void setCommEqpt(String commEqpt) {
		this.commEqpt = commEqpt;
	}
	public String getLifeEqpt() {
		return lifeEqpt;
	}
	public void setLifeEqpt(String lifeEqpt) {
		this.lifeEqpt = lifeEqpt;
	}
	public String getBoatlpc() {
		return boatlpc;
	}
	public void setBoatlpc(String boatlpc) {
		this.boatlpc = boatlpc;
	}
	public String getBoatetd() {
		return boatetd;
	}
	public void setBoatetd(String boatetd) {
		this.boatetd = boatetd;
	}
	public String getBoatnpc() {
		return boatnpc;
	}
	public void setBoatnpc(String boatnpc) {
		this.boatnpc = boatnpc;
	}
	public String getBoateta() {
		return boateta;
	}
	public void setBoateta(String boateta) {
		this.boateta = boateta;
	}
	public String getLicenseFish() {
		return licenseFish;
	}
	public void setLicenseFish(String licenseFish) {
		this.licenseFish = licenseFish;
	}
	public String getOwnerContDts() {
		return ownerContDts;
	}
	public void setOwnerContDts(String ownerContDts) {
		this.ownerContDts = ownerContDts;
	}
	public String getBoatColrcd() {
		return boatColrcd;
	}
	public void setBoatColrcd(String boatColrcd) {
		this.boatColrcd = boatColrcd;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getStateReg() {
		return stateReg;
	}
	public void setStateReg(String stateReg) {
		this.stateReg = stateReg;
	}
	public String getOwnerContCode() {
		return ownerContCode;
	}
	public void setOwnerContCode(String ownerContCode) {
		this.ownerContCode = ownerContCode;
	}
	public String getTypeOfBoat() {
		return typeOfBoat;
	}
	public void setTypeOfBoat(String typeOfBoat) {
		this.typeOfBoat = typeOfBoat;
	}
	
	public String getTypeOfBoatName() {
		return typeOfBoatName;
	}
	public void setTypeOfBoatName(String typeOfBoatName) {
		this.typeOfBoatName = typeOfBoatName;
	}
	@Override
	public String toString() {
		return "Boat [boatId=" + boatId + ", boatName=" + boatName + ", regNum=" + regNum + ", ownerName=" + ownerName
				+ ", portReg=" + portReg + ", noOfCrew=" + noOfCrew + ", docHeld=" + docHeld + ", navEqpt=" + navEqpt
				+ ", commEqpt=" + commEqpt + ", lifeEqpt=" + lifeEqpt + ", boatlpc=" + boatlpc + ", boatetd=" + boatetd
				+ ", boatnpc=" + boatnpc + ", boateta=" + boateta + ", licenseFish=" + licenseFish + ", ownerContDts="
				+ ownerContDts + ", boatColrcd=" + boatColrcd + ", remarks=" + remarks + ", ownerContCode="
				+ ownerContCode + ", stateReg=" + stateReg + ", typeOfBoat=" + typeOfBoat + ", typeOfBoatName="
				+ typeOfBoatName + "]";
	}
	
	
}
