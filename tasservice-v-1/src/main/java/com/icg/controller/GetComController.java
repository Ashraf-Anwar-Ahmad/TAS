package com.icg.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.icg.service.AddComboService;
import com.icg.serviceImpl.AddComboServiceImpl;

@Path("/checkInput")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GetComController {

	@Autowired
	private AddComboService addcombo=new AddComboServiceImpl();
	
	
		@GET
		public String checkInput(
				@QueryParam("inputId") String inputId
				)
				throws JsonProcessingException {
		///System.out.println("in controller"+inputId);
			String responseModel = addcombo.checkInputId(inputId);
			return responseModel;
		}
        
}
