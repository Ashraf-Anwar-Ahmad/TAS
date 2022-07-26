package com.icg.dto;

import java.util.List;

public class Test {

	private List<Contact> contctList;

	public List<Contact> getContctList() {
		return contctList;
	}

	public void setContctList(List<Contact> contctList) {
		this.contctList = contctList;
	}

	@Override
	public String toString() {
		return "Test [contctList=" + contctList + "]";
	}
	
	
}
