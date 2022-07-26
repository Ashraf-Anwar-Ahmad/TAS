package com.icg.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.icg.model.Test;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public String add(Test testcl) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/tasService/webapi/call/addTest";
		String result = restTemplate.postForObject(url, testcl, String.class);
		///System.out.println("result=="+result);
		return result;
		
	}
}
