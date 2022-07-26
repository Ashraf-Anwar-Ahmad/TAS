package com.icg.model;

public class Vessel {

	private String vesselId;
	private String vesselName;
	private String vesselTypeId;
	private String vesselTypeName;
	private String intCallSign;
	private String mmsi;
	private String imoNo;
	private String cargo;
	private String vessellpc;
	private String vesseletd;
	private String vesselnpc;
	private String vesseleta;
	private String totCrew;
	private String flgPrtReg;
	private String inmarsatNo;
	private String otherCommEqpt;
	private String agent;
	private String pans;
	public String getVesselId() {
		return vesselId;
	}
	public void setVesselId(String vesselId) {
		this.vesselId = vesselId;
	}
	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	public String getVesselTypeId() {
		return vesselTypeId;
	}
	public void setVesselTypeId(String vesselTypeId) {
		this.vesselTypeId = vesselTypeId;
	}
	public String getVesselTypeName() {
		return vesselTypeName;
	}
	public void setVesselTypeName(String vesselTypeName) {
		this.vesselTypeName = vesselTypeName;
	}
	public String getIntCallSign() {
		return intCallSign;
	}
	public void setIntCallSign(String intCallSign) {
		this.intCallSign = intCallSign;
	}
	public String getMmsi() {
		return mmsi;
	}
	public void setMmsi(String mmsi) {
		this.mmsi = mmsi;
	}
	public String getImoNo() {
		return imoNo;
	}
	public void setImoNo(String imoNo) {
		this.imoNo = imoNo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getVessellpc() {
		return vessellpc;
	}
	public void setVessellpc(String vessellpc) {
		this.vessellpc = vessellpc;
	}
	public String getVesseletd() {
		return vesseletd;
	}
	public void setVesseletd(String vesseletd) {
		this.vesseletd = vesseletd;
	}
	public String getVesselnpc() {
		return vesselnpc;
	}
	public void setVesselnpc(String vesselnpc) {
		this.vesselnpc = vesselnpc;
	}
	public String getVesseleta() {
		return vesseleta;
	}
	public void setVesseleta(String vesseleta) {
		this.vesseleta = vesseleta;
	}
	public String getTotCrew() {
		return totCrew;
	}
	public void setTotCrew(String totCrew) {
		this.totCrew = totCrew;
	}
	public String getFlgPrtReg() {
		return flgPrtReg;
	}
	public void setFlgPrtReg(String flgPrtReg) {
		this.flgPrtReg = flgPrtReg;
	}
	public String getInmarsatNo() {
		return inmarsatNo;
	}
	public void setInmarsatNo(String inmarsatNo) {
		this.inmarsatNo = inmarsatNo;
	}
	public String getOtherCommEqpt() {
		return otherCommEqpt;
	}
	public void setOtherCommEqpt(String otherCommEqpt) {
		this.otherCommEqpt = otherCommEqpt;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getPans() {
		return pans;
	}
	public void setPans(String pans) {
		this.pans = pans;
	}
	@Override
	public String toString() {
		return "Vessel [vesselId=" + vesselId + ", vesselName=" + vesselName + ", vesselTypeId=" + vesselTypeId
				+ ", vesselTypeName=" + vesselTypeName + ", intCallSign=" + intCallSign + ", mmsi=" + mmsi + ", imoNo="
				+ imoNo + ", cargo=" + cargo + ", vessellpc=" + vessellpc + ", vesseletd=" + vesseletd + ", vesselnpc="
				+ vesselnpc + ", vesseleta=" + vesseleta + ", totCrew=" + totCrew + ", flgPrtReg=" + flgPrtReg
				+ ", inmarsatNo=" + inmarsatNo + ", otherCommEqpt=" + otherCommEqpt + ", agent=" + agent + ", pans="
				+ pans + "]";
	}
	
	
	
	
}
