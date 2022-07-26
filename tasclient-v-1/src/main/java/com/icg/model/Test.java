package com.icg.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	/*private List<Contact> contctList;


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
*/
	
	public static void main(String[] args) {
		List<List<String>> crwStrList=new ArrayList<List<String>>();
		List<Contact> CrewStr=new ArrayList<Contact>();
		Contact cnt=new Contact();
		cnt.setContactNo("89898998");
		cnt.setCountry("India");
		Contact cnt1=new Contact();
		cnt1.setContactNo("89898998");
		cnt1.setCountry("Russia");
		CrewStr.add(cnt);
		CrewStr.add(cnt1);
		
		
		
		String citiesCommaSeparated = CrewStr.stream().map(contact -> contact.getCountry())
                .collect(Collectors.joining(","));

		System.out.println(citiesCommaSeparated);

		System.out.println("check=="+crwStrList.toString());
	}

	
	
	
}
