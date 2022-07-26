package com.icg.dto;

public class Imei {

	private String imeiId;
	private String imei;
	
	
	public String getImeiId() {
		return imeiId;
	}
	public void setImeiId(String imeiId) {
		this.imeiId = imeiId;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	@Override
	public String toString() {
		return "Imei [imeiId=" + imeiId + ", imei=" + imei + "]";
	}

	
	
}
