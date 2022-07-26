package com.icg.serviceImpl;

import com.icg.dao.SatelliteAndOtherDAO;
import com.icg.daoImpl.SatelliteAndOtherDAOImpl;
import com.icg.dto.SatelliteAndOther;
import com.icg.service.SatelliteAndOtherService;

public class SatelliteAndOtherServiceImpl implements SatelliteAndOtherService {

	SatelliteAndOtherDAO satelliteAndOtherDAO = new SatelliteAndOtherDAOImpl();
	@Override
	public String save(SatelliteAndOther threat) {
		// TODO Auto-generated method stub
		return satelliteAndOtherDAO.save(threat);
	}

	@Override
	public SatelliteAndOther findById(String id) {
		// TODO Auto-generated method stub
		return satelliteAndOtherDAO.findById(id);
	}

	@Override
	public String update(SatelliteAndOther threat) {
		// TODO Auto-generated method stub
		return satelliteAndOtherDAO.update(threat);
	}
	
	
	@Override
	public String saveOther(SatelliteAndOther threat) {
		// TODO Auto-generated method stub
		return satelliteAndOtherDAO.saveOther(threat);
	}
	
	@Override
	public String updateOther(SatelliteAndOther threat) {
		// TODO Auto-generated method stub
		return satelliteAndOtherDAO.updateOther(threat);
	}

}
