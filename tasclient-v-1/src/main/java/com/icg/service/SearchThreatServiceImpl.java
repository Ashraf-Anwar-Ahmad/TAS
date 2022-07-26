package com.icg.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.icg.model.ViewPDFBean;
import com.icg.util.MessageExtension;

@Service
public class SearchThreatServiceImpl implements SearchThreatService{
	
	@Override
	public String getSearchThreatList(String ... varArg) {
				
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL+"searchThreat/getSearchThreatList?searchBy="+varArg[0]+"&searchTerm="+varArg[1];
		String result = restTemplate.getForObject(url, String.class);

	return result;
		
	}
	
	@Override
	public String getThreatHistoryList(String... varArg) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL+"searchThreat/getThreatHistoryList";
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
	
	
	
	@Override
	public String getViewList(String... varArg){
				
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL+"searchThreat/getViewList";
		String result = restTemplate.getForObject(url, String.class);
		return result;
		
		
	}
	
	@Override
	public ViewPDFBean getViewPdfList(String... varArg) {
	RestTemplate restTemplate = new RestTemplate();
	String url = MessageExtension.BASE_URL+"searchThreat/getViewPdfList?genDtlsId="+varArg[0];
	ViewPDFBean threat = restTemplate.getForObject(url, ViewPDFBean.class);
	//System.out.println("threat--"+threat.toString());

	return threat;
	}
	
	
	@Override
	public String getSearchThreatList(String imeiNo, String contactNo, String latitude, String longitude, String region,
			String state, String location, String fromDate, String toDate, String boatName, String vesselName,
			String crewName, String inputId, String threatType, String narcoticType, String contrabandType,
			String boatRegNo, String boatPortOfReg, String boatLPC, String boatNPC, String originator, String grading,
			String vesselFlagAndPortOfReg) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "searchThreat/getSearchThreatListNew?imeiNo=" + imeiNo + "&contactNo="
				+ contactNo + "&latitude=" + latitude + "&longitude=" + longitude + "&region=" + region + "&state="
				+ state + "&location=" + location + "&fromDate=" + fromDate + "&toDate=" + toDate + "&boatName="
				+ boatName + "&vesselName=" + vesselName + "&crewName=" + crewName + "&inputId=" + inputId
				+ "&threatType=" + threatType + "&narcoticType=" + narcoticType + "&contrabandType=" + contrabandType
				+ "&boatRegNo=" + boatRegNo + "&boatPortOfReg=" + boatPortOfReg + "&boatLPC=" + boatLPC + "&boatNPC="
				+ boatNPC + "&originator=" + originator + "&grading=" + grading + "&vesselFlagAndPortOfReg="
				+ vesselFlagAndPortOfReg;
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
	

}
