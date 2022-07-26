package com.icg.model;

public class Crew {

	private String crId;
	private String crName;
	private String crAge;
	private String crNationality;
	private String crAddress;
	private String crTelNo;
	private String crMartStsId;
	private String crMartSts;
	private String crProfession;
	private String crIdenMrks;
	private String crRelgnId;
	private String crRelgn;
	private String crDtlsIdPf;
	
	////Added By rakesh
	private String gender ;
	private String genderDpsc ;
	
	
	//added on 1st June
	private String crCountCode;
	private String crDtlsIdType;
	private String crDtlsIdTypeName;
	
	

	public String getCrDtlsIdTypeName() {
		return crDtlsIdTypeName;
	}
	public void setCrDtlsIdTypeName(String crDtlsIdTypeName) {
		this.crDtlsIdTypeName = crDtlsIdTypeName;
	}
	public String getCrId() {
		return crId;
	}
	public void setCrId(String crId) {
		this.crId = crId;
	}
	public String getCrName() {
		return crName;
	}
	public void setCrName(String crName) {
		this.crName = crName;
	}
	public String getCrAge() {
		return crAge;
	}
	public void setCrAge(String crAge) {
		this.crAge = crAge;
	}
	public String getCrNationality() {
		return crNationality;
	}
	public void setCrNationality(String crNationality) {
		this.crNationality = crNationality;
	}
	public String getCrAddress() {
		return crAddress;
	}
	public void setCrAddress(String crAddress) {
		this.crAddress = crAddress;
	}
	public String getCrTelNo() {
		return crTelNo;
	}
	public void setCrTelNo(String crTelNo) {
		this.crTelNo = crTelNo;
	}
	public String getCrMartSts() {
		return crMartSts;
	}
	public void setCrMartSts(String crMartSts) {
		this.crMartSts = crMartSts;
	}
	public String getCrProfession() {
		return crProfession;
	}
	public void setCrProfession(String crProfession) {
		this.crProfession = crProfession;
	}
	public String getCrIdenMrks() {
		return crIdenMrks;
	}
	public void setCrIdenMrks(String crIdenMrks) {
		this.crIdenMrks = crIdenMrks;
	}
	public String getCrRelgn() {
		return crRelgn;
	}
	public void setCrRelgn(String crRelgn) {
		this.crRelgn = crRelgn;
	}
	public String getCrDtlsIdPf() {
		return crDtlsIdPf;
	}
	public void setCrDtlsIdPf(String crDtlsIdPf) {
		this.crDtlsIdPf = crDtlsIdPf;
	}
	public String getCrMartStsId() {
		return crMartStsId;
	}
	public void setCrMartStsId(String crMartStsId) {
		this.crMartStsId = crMartStsId;
	}
	public String getCrRelgnId() {
		return crRelgnId;
	}
	public void setCrRelgnId(String crRelgnId) {
		this.crRelgnId = crRelgnId;
	}
	
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getGenderDpsc() {
		return genderDpsc;
	}
	public void setGenderDpsc(String genderDpsc) {
		this.genderDpsc = genderDpsc;
	}
	public String getCrCountCode() {
		return crCountCode;
	}
	public void setCrCountCode(String crCountCode) {
		this.crCountCode = crCountCode;
	}
	public String getCrDtlsIdType() {
		return crDtlsIdType;
	}
	public void setCrDtlsIdType(String crDtlsIdType) {
		this.crDtlsIdType = crDtlsIdType;
	}
	@Override
	public String toString() {
		return "Crew [crId=" + crId + ", crName=" + crName + ", crAge=" + crAge + ", crNationality=" + crNationality
				+ ", crAddress=" + crAddress + ", crTelNo=" + crTelNo + ", crMartStsId=" + crMartStsId + ", crMartSts="
				+ crMartSts + ", crProfession=" + crProfession + ", crIdenMrks=" + crIdenMrks + ", crRelgnId="
				+ crRelgnId + ", crRelgn=" + crRelgn + ", crDtlsIdPf=" + crDtlsIdPf + ", gender=" + gender
				+ ", genderDpsc=" + genderDpsc + ", crCountCode=" + crCountCode + ", crDtlsIdType=" + crDtlsIdType
				+ ", crDtlsIdTypeName=" + crDtlsIdTypeName + "]";
	}

	
	
	
}
