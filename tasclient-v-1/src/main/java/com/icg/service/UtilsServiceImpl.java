package com.icg.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icg.model.DropdownMaster;
import com.icg.util.MessageExtension;

@Service
public class UtilsServiceImpl implements UtilsService {
	

	@Override
	public List<DropdownMaster> getMaster(String id1,String id2){
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL+"getCombo?id="+id1+"&type="+id2;
		//System.out.println("url      "+url);
		
		String result = restTemplate.getForObject(url, String.class);

		ObjectMapper mapper = new ObjectMapper() ;
		List<DropdownMaster> list = null ;
		try {
		list = mapper.readValue(result, new TypeReference<List<DropdownMaster>>(){});
		} catch (IOException e) {
		e.printStackTrace();
		}
		return list;
	}

	@Override
	public String checkInputId(String inpuId) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL+"checkInput?inputId="+inpuId;
		String result = restTemplate.getForObject(url, String.class);
		//System.out.println("result=="+result);
		return result;
	}
	
	

}
