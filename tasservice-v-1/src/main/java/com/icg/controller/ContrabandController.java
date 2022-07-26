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
import com.icg.dto.ContrabandThreat;
import com.icg.dto.HumanTrafficing;
import com.icg.dto.NarcoticThreat;
import com.icg.service.ContrabandService;
import com.icg.serviceImpl.ContrabandServiceImpl;

@Path("/call")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContrabandController {

	@Autowired
	ContrabandService contService = new ContrabandServiceImpl();

	@POST
	@Path("/addContraband")
	public String addThreat(ContrabandThreat threat) throws JsonProcessingException {
		String responseModel = contService.add(threat);
		// System.out.println("responseModel==" + responseModel);
		return responseModel;
	}

	@GET
	@Path("/getContraband")
	public ContrabandThreat findById(@QueryParam("id") String id) {
		ContrabandThreat threat = contService.findDataById(id);
		//System.out.println("in threat get contraband controller==" + threat.toString());
		return threat;

	}

	@POST
	@Path("/updateContraband")
	public String updateThreat(ContrabandThreat threat) throws JsonProcessingException {
		/// System.out.println("in controller" + threat.toString());

		String responseModel = contService.update(threat);
		// System.out.println("responseModel==" + responseModel);
		return responseModel;

	}

	// below for narcotics

	@POST
	@Path("/addNarcotic")
	public String addNarcotic(NarcoticThreat threat) throws JsonProcessingException {
		String responseModel = contService.addNarco(threat);
		return responseModel;

	}

	@GET
	@Path("/getNarcotic")
	public NarcoticThreat findNrcoById(@QueryParam("id") String id) {
		NarcoticThreat threat = contService.findNacoDataById(id);
		System.out.println("in threat get contraband controller==" + threat.toString());
		return threat;

	}

	@POST
	@Path("/updateNarcotic")
	public String updateNarcThreat(NarcoticThreat threat) throws JsonProcessingException {
		/// System.out.println("in controller" + threat.toString());

		String responseModel = contService.updateNarco(threat);
		//// System.out.println("responseModel==" + responseModel);
		return responseModel;

	}

// Added by Rakesh Kumar	
	@POST
	@Path("/addHumanThreat")
	public String addHumanThreat(HumanTrafficing threat) throws JsonProcessingException {
		String responseModel = contService.addHumanThreat(threat);
		return responseModel;
	}

	@GET
	@Path("/getHumanThreatById")
	public HumanTrafficing getHumanThreatById(@QueryParam("id") String id) {
		HumanTrafficing threat = contService.findHumanTrafficingById(id);
		System.out.println("in  huan threat get contraband controller==" + threat.toString());
		return threat;

	}

	@POST
	@Path("/updateHumanThreat")
	public String updateHumanThreat(HumanTrafficing threat) throws JsonProcessingException {
		/// System.out.println(" h in controller" + threat.toString());

		String responseModel = contService.updateHumanTrafficing(threat);
		// System.out.println(" update h responseModel==" + responseModel);
		return responseModel;

	}
}
