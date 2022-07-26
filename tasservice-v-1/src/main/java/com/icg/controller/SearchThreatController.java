package com.icg.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.icg.dto.GetSearchDTO;
import com.icg.dto.ViewPDFBean;
import com.icg.service.SearchThreatService;
import com.icg.serviceImpl.SearchThreatServiceImpl;

@Path("/searchThreat")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SearchThreatController {

	@Autowired
	private SearchThreatService searchThreatService = new SearchThreatServiceImpl();

	@GET
	@Path("/getSearchThreatList")
	public String getSearchThreatList(@QueryParam("searchBy") String searchBy,
			@QueryParam("searchTerm") String searchTerm) throws JsonProcessingException {
		//System.out.println(searchBy + "--" + searchTerm);
		String responseModel = searchThreatService.getSearchThreatList(searchBy, searchTerm);
		return responseModel;

	}

	@GET
	@Path("/getSearchThreatListNew")
	public String save(@QueryParam("imeiNo") String imeiNo, @QueryParam("contactNo") String contactNo,
			@QueryParam("latitude") String latitude, @QueryParam("longitude") String longitude,
			@QueryParam("region") String region, @QueryParam("state") String state,
			@QueryParam("location") String location, @QueryParam("fromDate") String fromDate,
			@QueryParam("toDate") String toDate, @QueryParam("boatName") String boatName,
			@QueryParam("vesselName") String vesselName, @QueryParam("crewName") String crewName,
			@QueryParam("inputId") String inputId, @QueryParam("threatType") String threatType,
			@QueryParam("narcoticType") String narcoticType, @QueryParam("contrabandType") String contrabandType,
			@QueryParam("boatRegNo") String boatRegNo, @QueryParam("boatPortOfReg") String boatPortOfReg,
			@QueryParam("boatLPC") String boatLPC, @QueryParam("boatNPC") String boatNPC,
			@QueryParam("originator") String originator, @QueryParam("grading") String grading,
			@QueryParam("vesselFlagAndPortOfReg") String vesselFlagAndPortOfReg) throws JsonProcessingException {
		////System.out.println("in controller" + imeiNo);
		GetSearchDTO getSearchDTO = new GetSearchDTO();
		getSearchDTO.setImeiNo(imeiNo);
		getSearchDTO.setContactNo(contactNo);
		getSearchDTO.setLatitude(latitude);
		getSearchDTO.setLongitude(longitude);
		getSearchDTO.setRegion(region);
		getSearchDTO.setState(state);
		getSearchDTO.setLocation(location);
		getSearchDTO.setFromDate(fromDate);
		getSearchDTO.setToDate(toDate);
		getSearchDTO.setBoatName(boatName);
		getSearchDTO.setVesselName(vesselName);
		getSearchDTO.setCrewName(crewName);
		getSearchDTO.setInputId(inputId);
		getSearchDTO.setThreatType(threatType);
		getSearchDTO.setNarcoticType(narcoticType);
		getSearchDTO.setContrabandType(contrabandType);
		getSearchDTO.setBoatRegNo(boatRegNo);
		getSearchDTO.setBoatPortOfReg(boatPortOfReg);
		getSearchDTO.setBoatLPC(boatLPC);
		getSearchDTO.setBoatNPC(boatNPC);
		getSearchDTO.setOriginator(originator);
		getSearchDTO.setGrading(grading);
		getSearchDTO.setVesselFlagAndPortOfReg(vesselFlagAndPortOfReg);
//		String responseModel = searchThreatService.getSearchThreatList(searchBy, searchTerm);
		String responseModel = searchThreatService.getSearchThreatList(getSearchDTO);
		//System.out.println("responseModel==" + responseModel);
		return responseModel;

	}

	@GET
	@Path("/getViewPdfList")
	public ViewPDFBean getViewPdfList(@QueryParam("genDtlsId") String genDtlsId) throws JsonProcessingException {
		//System.out.println("in getSearchThreatList --" + genDtlsId);

		ViewPDFBean responseModel = searchThreatService.getViewPdfList(genDtlsId);
		return responseModel;

	}

	@GET
	@Path("/getThreatHistoryList")
	public String getThreatHistoryList() throws JsonProcessingException {

		String responseModel = searchThreatService.getThreatHistoryList();
		return responseModel;

	}

	@GET
	@Path("/getViewList")
	public String getViewList() throws JsonProcessingException {
		String responseModel = searchThreatService.getViewList();
		return responseModel;
	}

}