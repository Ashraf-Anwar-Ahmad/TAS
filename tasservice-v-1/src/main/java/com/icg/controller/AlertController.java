package com.icg.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.icg.dto.ThreatCheck;
import com.icg.service.ThreatService;
import com.icg.serviceImpl.ThreatServiceImpl;

@Path("/call")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlertController {
	
	@Autowired
	ThreatService alrtService=new ThreatServiceImpl();

	@POST
	@Path("/alert")
	public String check(
			ThreatCheck threat
			)
			throws JsonProcessingException {
		//System.out.println("in controller"+threat.toString());
		
		String list = alrtService.getList(threat);
		///System.out.println("responseModel=="+list.toString());
		return list;
		
	}
}
