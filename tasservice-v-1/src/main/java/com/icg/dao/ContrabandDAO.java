package com.icg.dao;

import com.icg.dto.ContrabandThreat;
import com.icg.dto.HumanTrafficing;
import com.icg.dto.NarcoticThreat;

public interface ContrabandDAO {
	

	public String add(ContrabandThreat threat);
	
	public ContrabandThreat findDataById(String id);
	
	public String update(ContrabandThreat threat);
	
	
	//below for narcotics
	
	public String addNarco(NarcoticThreat threat);
	
	public NarcoticThreat findNacoDataById(String id);
	
	public String updateNarco(NarcoticThreat threat);
	
	//below for human trafficking
	
	public String addHumanThreat(HumanTrafficing threat);
		
	public HumanTrafficing findHumanTrafficingById(String id);
		
	public String updateHumanTrafficing(HumanTrafficing threat);
}
