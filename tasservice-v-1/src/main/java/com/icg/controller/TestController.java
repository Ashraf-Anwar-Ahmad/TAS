package com.icg.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.icg.dto.Test;
import com.icg.service.TestService;
import com.icg.serviceImpl.TestServiceImpl;

@Path("/call")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestController {

	@Autowired
	TestService test=new TestServiceImpl();
	
	
	@POST
	@Path("/addTest")
	public String addGroup(
			Test testcl
			)
			throws JsonProcessingException {
		//System.out.println("in controller"+contact.toString());
		
		String responseModel = test.add(testcl);
		//System.out.println("responseModel=="+responseModel);
		return responseModel;
		
	}
}
