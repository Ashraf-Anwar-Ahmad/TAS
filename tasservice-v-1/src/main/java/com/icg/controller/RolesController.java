package com.icg.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.icg.dto.ResponseModel;
import com.icg.extention.ResponseCreatorExtension;
import com.icg.service.RolesService;
import com.icg.serviceImpl.RolesServiceImpl;

@Path("/assign")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RolesController {

	private RolesService rolesService = new RolesServiceImpl();
	
	
	@GET
	@Path("/getRoles")
	public Response getRoles(@QueryParam("userId") String userId)
			throws JsonProcessingException {
		///System.out.println("in controller "+userId);
		ResponseModel responseModel = rolesService.getRoles(userId);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}
	
}
