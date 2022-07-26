package com.icg.dto;

public class GetBean {
	
	private String id;
	private String descr;
	private String sDescr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getsDescr() {
		return sDescr;
	}
	public void setsDescr(String sDescr) {
		this.sDescr = sDescr;
	}
	@Override
	public String toString() {
		return "GetBean [id=" + id + ", descr=" + descr + ", sDescr=" + sDescr + "]";
	}
	
	
	

}
