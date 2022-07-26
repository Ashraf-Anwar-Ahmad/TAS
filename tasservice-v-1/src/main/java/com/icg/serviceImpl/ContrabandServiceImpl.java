package com.icg.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.icg.dao.ContrabandDAO;
import com.icg.daoImpl.ContrabandDAOImpl;
import com.icg.dto.ContrabandThreat;
import com.icg.dto.HumanTrafficing;
import com.icg.dto.NarcoticThreat;
import com.icg.service.ContrabandService;

public class ContrabandServiceImpl implements ContrabandService {

	
	@Autowired
	ContrabandDAO contraDao=new ContrabandDAOImpl();
	
	public String add(ContrabandThreat threat) {
		return contraDao.add(threat);
	}

	public ContrabandThreat findDataById(String id) {
		return contraDao.findDataById(id);
	}
	
	public String update(ContrabandThreat threat) {
		return contraDao.update(threat);
	}

	//below for narcotic threat
	public String addNarco(NarcoticThreat threat) {
		return contraDao.addNarco(threat);
	}

	public NarcoticThreat findNacoDataById(String id) {
		return contraDao.findNacoDataById(id);
	}

	public String updateNarco(NarcoticThreat threat) {
		return contraDao.updateNarco(threat);
	}
   // Added by rakesh kumar
	@Override
	public String addHumanThreat(HumanTrafficing threat) {
		
		 return contraDao.addHumanThreat(threat);
	}

	@Override
	public HumanTrafficing findHumanTrafficingById(String id) {
		
		return contraDao.findHumanTrafficingById(id);
	}

	@Override
	public String updateHumanTrafficing(HumanTrafficing threat) {
		return contraDao.updateHumanTrafficing(threat);
	}

}
