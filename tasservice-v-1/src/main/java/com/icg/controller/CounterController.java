package com.icg.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.icg.dto.CounterThreat;
import com.icg.service.CounterService;
import com.icg.serviceImpl.CounterServiceImpl;

@Path("/call")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CounterController {

	@Autowired
	CounterService contService = new CounterServiceImpl();

	@POST
	@Path("/addCounter")
	public String addThreat(CounterThreat threat) throws JsonProcessingException {
		String responseModel = contService.add(threat);
		return responseModel;

	}

	@GET
	@Path("/getCounter")
	public CounterThreat findById(@QueryParam("id") String id) {
		CounterThreat threat = contService.findDataById(id);
		//System.out.println("in threat get CounterThreat controller==" + threat.toString());
		return threat;

	}

	@POST
	@Path("/updateCounter")
	public String updateThreat(CounterThreat threat) throws JsonProcessingException {
		// System.out.println("in controller"+threat.toString());

		String responseModel = contService.update(threat);
		// System.out.println("responseModel=="+responseModel);
		return responseModel;

	}
}
