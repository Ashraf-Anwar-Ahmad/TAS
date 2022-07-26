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
import com.icg.dto.SatelliteAndOther;
import com.icg.service.SatelliteAndOtherService;
import com.icg.serviceImpl.SatelliteAndOtherServiceImpl;

@Path("/satelliteOther")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SatelliteAndOtherController {

	@Autowired
	SatelliteAndOtherService satelliteAndOtherService=new SatelliteAndOtherServiceImpl();


	@POST
	@Path("/save")
	public String save(SatelliteAndOther threat)throws JsonProcessingException {
		//System.out.println("<<<SatelliteAndOtherin controller>>>"+threat.toString());

		String responseModel = satelliteAndOtherService.save(threat);
		///System.out.println("responseModel=="+responseModel);
		return responseModel;

	}

	@GET
	@Path("/findById")
	public SatelliteAndOther findById(@QueryParam("id")String id)
	{
		SatelliteAndOther threat = satelliteAndOtherService.findById(id);
		//System.out.println("in threat get satelliteAndOther controller=="+threat.toString());
		return threat;

	}

	@POST
	@Path("/update")
	public String update(SatelliteAndOther threat)throws JsonProcessingException {
		//System.out.println("in controller"+threat.toString());
		String responseModel = satelliteAndOtherService.update(threat);
		//System.out.println("responseModel=="+responseModel);
		return responseModel;

	}



	@POST
	@Path("/saveOther")
	public String saveOther(SatelliteAndOther threat)throws JsonProcessingException {
		String responseModel = satelliteAndOtherService.saveOther(threat);
		///System.out.println("responseModel=="+responseModel);
		return responseModel;
	}

	@POST
	@Path("/updateOther")
	public String updateOther(SatelliteAndOther threat)throws JsonProcessingException {
		String responseModel = satelliteAndOtherService.updateOther(threat);
		///System.out.println("responseModel=="+responseModel);
		return responseModel;	

	}



}
