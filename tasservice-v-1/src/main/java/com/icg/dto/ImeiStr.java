package com.icg.dto;

import java.util.List;

public class ImeiStr {
	private List<Imei> imeiList;
	private List<List<String>> imeiStrList;
	public List<Imei> getImeiList() {
		return imeiList;
	}
	public void setImeiList(List<Imei> imeiList) {
		this.imeiList = imeiList;
	}
	public List<List<String>> getImeiStrList() {
		return imeiStrList;
	}
	public void setImeiStrList(List<List<String>> imeiStrList) {
		this.imeiStrList = imeiStrList;
	}
	@Override
	public String toString() {
		return "ImeiStr [imeiList=" + imeiList + ", imeiStrList=" + imeiStrList + "]";
	}
}
