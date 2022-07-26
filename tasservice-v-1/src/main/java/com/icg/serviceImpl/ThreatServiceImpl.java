package com.icg.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.icg.dao.ThreatDAO;
import com.icg.daoImpl.ThreatDAOImpl;
import com.icg.dto.ThreatCheck;
import com.icg.service.ThreatService;

public class ThreatServiceImpl implements ThreatService {

	@Autowired
	ThreatDAO threatDao=new ThreatDAOImpl();

	public String getList(ThreatCheck threat) {
		return threatDao.getList(threat);
	}

}
