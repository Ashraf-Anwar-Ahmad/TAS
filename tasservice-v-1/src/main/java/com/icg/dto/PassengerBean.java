package com.icg.dto;

public class PassengerBean {
	private String name;
	private String age;
	private String gender;
	private String genderDescr;
	private String nationality;
	private String address;
	private String telephoneNumber;
	private String number;
	private String maritalStatus;
	private String maritalStatusDescr;
	private String profession;
	private String identificationMarks;
	private String religion;
	private String religionDescr;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGenderDescr() {
		return genderDescr;
	}
	public void setGenderDescr(String genderDescr) {
		this.genderDescr = genderDescr;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getMaritalStatusDescr() {
		return maritalStatusDescr;
	}
	public void setMaritalStatusDescr(String maritalStatusDescr) {
		this.maritalStatusDescr = maritalStatusDescr;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getIdentificationMarks() {
		return identificationMarks;
	}
	public void setIdentificationMarks(String identificationMarks) {
		this.identificationMarks = identificationMarks;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getReligionDescr() {
		return religionDescr;
	}
	public void setReligionDescr(String religionDescr) {
		this.religionDescr = religionDescr;
	}
	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", gender=" + gender + ", genderDescr=" + genderDescr
				+ ", nationality=" + nationality + ", address=" + address + ", telephoneNumber=" + telephoneNumber
				+ ", number=" + number + ", maritalStatus=" + maritalStatus + ", maritalStatusDescr="
				+ maritalStatusDescr + ", profession=" + profession + ", identificationMarks=" + identificationMarks
				+ ", religion=" + religion + ", religionDescr=" + religionDescr + "]";
	}
	
	
		
	

}
