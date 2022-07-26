package com.icg.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icg.model.ContrabandThreat;
import com.icg.model.CounterThreat;
import com.icg.model.DropdownMaster;
import com.icg.model.HumanTrafficing;
import com.icg.model.Map;
import com.icg.model.NarcoticThreat;
import com.icg.model.SatelliteAndOther;

public class convertToString {
	
	public static String change(ContrabandThreat thrt){
		ObjectMapper mapper = new ObjectMapper();

		String newsLetterJSON=null;

		try {

		newsLetterJSON = mapper.writeValueAsString(thrt);

		} catch (JsonProcessingException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

		}
		return newsLetterJSON;
	
}
	
	public static String changecounter(CounterThreat thrt){
		ObjectMapper mapper = new ObjectMapper();

		String newsLetterJSON=null;

		try {

		newsLetterJSON = mapper.writeValueAsString(thrt);

		} catch (JsonProcessingException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

		}
		return newsLetterJSON;
	
}
	
	public static String changenarco(NarcoticThreat thrt){
		ObjectMapper mapper = new ObjectMapper();

		String newsLetterJSON=null;

		try {

		newsLetterJSON = mapper.writeValueAsString(thrt);

		} catch (JsonProcessingException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

		}
		return newsLetterJSON;
	
}
	public static String changeDropdown(List<DropdownMaster> list){
		ObjectMapper mapper = new ObjectMapper();

		String newsLetterJSON=null;

		try {

		newsLetterJSON = mapper.writeValueAsString(list);

		} catch (JsonProcessingException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

		}
		return newsLetterJSON;
	
}
	
	// Added By Rakesh kumar 
	public static String getJson(HumanTrafficing  thrt){
		ObjectMapper mapper = new ObjectMapper();

		String newsLetterJSON=null;

		try {

		newsLetterJSON = mapper.writeValueAsString(thrt);

		} catch (JsonProcessingException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

		}
		return newsLetterJSON;
	
}

	public static String getJson(SatelliteAndOther  thrt){
		ObjectMapper mapper = new ObjectMapper();

		String newsLetterJSON=null;

		try {

		newsLetterJSON = mapper.writeValueAsString(thrt);

		} catch (JsonProcessingException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

		}
		return newsLetterJSON;
	
}
	public static String changeMap(List<Map> list){
		ObjectMapper mapper = new ObjectMapper();

		String newsLetterJSON=null;

		try {

		newsLetterJSON = mapper.writeValueAsString(list);

		} catch (JsonProcessingException e) {

		// TODO Auto-generated catch block

		e.printStackTrace();

		}
		return newsLetterJSON;
	
}
	
}
