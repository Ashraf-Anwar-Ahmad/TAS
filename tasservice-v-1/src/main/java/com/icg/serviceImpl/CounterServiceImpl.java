package com.icg.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.icg.dao.CounterDAO;
import com.icg.daoImpl.CounterDAOImpl;
import com.icg.dto.CounterThreat;
import com.icg.service.CounterService;

public class CounterServiceImpl implements CounterService{
	
	@Autowired
	CounterDAO countDao=new CounterDAOImpl();

	public String add(CounterThreat threat) {
		return countDao.add(threat);
	}

	public CounterThreat findDataById(String id) {
		return countDao.findDataById(id);
	}

	public String update(CounterThreat threat) {
		return countDao.update(threat);
	}

}
