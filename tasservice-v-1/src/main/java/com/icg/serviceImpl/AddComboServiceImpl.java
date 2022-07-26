package com.icg.serviceImpl;

import com.icg.dao.AddComboDAO;
import com.icg.daoImpl.AddComboDAOImpl;
import com.icg.service.AddComboService;

public class AddComboServiceImpl implements AddComboService{

	AddComboDAO addComboDAO = new AddComboDAOImpl();

	public String getCombo(String id, String type) {
		// TODO Auto-generated method stub
		return addComboDAO.getCombo(id, type);
	}
	
	public String getComboMem(String id, String type){
		return addComboDAO.getComboMem(id, type);
	}

	@Override
	public String checkInputId(String inpuId) {
		return addComboDAO.checkInputId(inpuId);
	}
}
