package com.icg.service;

import com.icg.model.ViewPDFBean;

public interface SearchThreatService {
	
	public String getSearchThreatList(String... varArg);
	public String getThreatHistoryList(String... varArg);
	public String getViewList(String... varArg);
	public ViewPDFBean getViewPdfList(String... varArg);

	
	
	public String getSearchThreatList(String imeiNo, String contactNo, String latitude, String longitude, String region,
			String state, String location, String fromDate, String toDate, String boatName, String vesselName,
			String crewName, String inputId, String threatType, String narcoticType, String contrabandType,
			String boatRegNo, String boatPortOfReg, String boatLPC, String boatNPC, String originator, String grading,
			String vesselFlagAndPortOfReg);
	
}
