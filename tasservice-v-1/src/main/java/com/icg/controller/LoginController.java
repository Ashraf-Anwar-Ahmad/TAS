package com.icg.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.icg.serviceImpl.LoginServiceImpl;


@Path("/login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginController {
	
	/*@POST
	public Response getLogin(@QueryParam("userName") String userName, @QueryParam("password") String password)
			throws JsonProcessingException {
	
		ResponseModel responseModel = new LoginServiceImpl().getLogin(userName, password);
		return ResponseCreatorExtension.responseCreator(responseModel);
	}*/
	@POST
	public String validateUser(@QueryParam("userName") String userName, @QueryParam("password") String password)
			throws JsonProcessingException {

	 String responce=new LoginServiceImpl().validateUser(userName,password);
	 return responce;
}
}