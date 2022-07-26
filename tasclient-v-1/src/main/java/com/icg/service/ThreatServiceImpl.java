package com.icg.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icg.model.ContrabandThreat;
import com.icg.model.CounterThreat;
import com.icg.model.HumanTrafficing;
import com.icg.model.NarcoticThreat;
import com.icg.model.SatelliteAndOther;
import com.icg.model.ThreatCheck;
import com.icg.model.ThreatReceive;
import com.icg.util.MessageExtension;

@Service
public class ThreatServiceImpl implements ThreatService {

	// below for contraband smuggling
	@Override
	public String add(ContrabandThreat threat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "call/addContraband";
		String result = restTemplate.postForObject(url, threat, String.class);
		return result;
	}

	@Override
	public ContrabandThreat findById(String id) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "call/getContraband?id=" + id;
		ContrabandThreat threat = restTemplate.getForObject(url, ContrabandThreat.class);
		return threat;
	}

	@Override
	public String update(ContrabandThreat threat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "call/updateContraband";
		String result = restTemplate.postForObject(url, threat, String.class);
		// System.out.println("result==" + result);
		return result;
	}

	// below for counter terrorism

	@Override
	public String addCounter(CounterThreat threat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "call/addCounter";
		String result = restTemplate.postForObject(url, threat, String.class);
		/// System.out.println("result==" + result);
		return result;
	}

	@Override
	public CounterThreat findCounterById(String id) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "call/getCounter?id=" + id;
		CounterThreat threat = restTemplate.getForObject(url, CounterThreat.class);
		// System.out.println("result==" + threat.toString());
		return threat;
	}

	@Override
	public String updateCounter(CounterThreat threat) {
		RestTemplate restTemplate = new RestTemplate();
		// System.out.println("threat==" + threat.toString());
		String url = MessageExtension.BASE_URL + "call/updateCounter";
		String result = restTemplate.postForObject(url, threat, String.class);
		// System.out.println("result==" + result);
		return result;
	}

	@Override
	public List<ThreatReceive> getList(ThreatCheck threat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "call/alert";
		String result = restTemplate.postForObject(url, threat, String.class);

		ObjectMapper mapper = new ObjectMapper();
		List<ThreatReceive> list = null;
		try {
			list = mapper.readValue(result, new TypeReference<List<ThreatReceive>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String addNarcotic(NarcoticThreat threat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "call/addNarcotic";
		/// System.out.println("url==" + url + "==threat==" + threat.toString());
		String result = restTemplate.postForObject(url, threat, String.class);
		// System.out.println("result==" + result);
		return result;
	}

	@Override
	public NarcoticThreat findNarcoticById(String id) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "call/getNarcotic?id=" + id;
		NarcoticThreat threat = restTemplate.getForObject(url, NarcoticThreat.class);
		// System.out.println("result==" + threat.toString());
		return threat;
	}

	@Override
	public String updateNarcotic(NarcoticThreat threat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "call/updateNarcotic";
		String result = restTemplate.postForObject(url, threat, String.class);
		// System.out.println("result==" + result);
		return result;
	}

	@Override
	public String save(HumanTrafficing threat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "call/addHumanThreat";
		String result = restTemplate.postForObject(url, threat, String.class);
		// System.out.println(url + " human trafficking result==" + result);
		return result;
	}

	@Override
	public HumanTrafficing findHumanTraffickingById(String id) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "call/getHumanThreatById?id=" + id;
		HumanTrafficing threat = restTemplate.getForObject(url, HumanTrafficing.class);
		// System.out.println("result=="+threat.toString());
		return threat;
	}

	@Override
	public String updateHumanTrafficking(HumanTrafficing threat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "call/updateHumanThreat";
		String result = restTemplate.postForObject(url, threat, String.class);
		// System.out.println("update human trafficking result=="+result);
		return result;
	}

	// Added for Satellite & Others

	@Override
	public String save(SatelliteAndOther threat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "satelliteOther/save";
		String result = restTemplate.postForObject(url, threat, String.class);
		/// System.out.println(threat.toString() + "<<<<update human trafficking
		/// result==>>>>"+result);
		return result;
	}

	@Override
	public SatelliteAndOther findSatelliteAndOtherById(String id) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "satelliteOther/findById?id=" + id;
		SatelliteAndOther threat = restTemplate.getForObject(url, SatelliteAndOther.class);
		// System.out.println("result=="+threat.toString());
		return threat;
	}

	@Override
	public String update(SatelliteAndOther threat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "satelliteOther/update";
		String result = restTemplate.postForObject(url, threat, String.class);
		// System.out.println("update human trafficking result=="+result);
		return result;
	}

	// Added for Others
	@Override
	public String saveOther(SatelliteAndOther threat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "satelliteOther/saveOther";
		String result = restTemplate.postForObject(url, threat, String.class);
		// System.out.println("result=>>" + result);
		return result;
	}

	@Override
	public String updateOther(SatelliteAndOther threat) {
		RestTemplate restTemplate = new RestTemplate();
		String url = MessageExtension.BASE_URL + "satelliteOther/updateOther";
		String result = restTemplate.postForObject(url, threat, String.class);
		// System.out.println("result=>>" + result);
		return result;
	}

}
