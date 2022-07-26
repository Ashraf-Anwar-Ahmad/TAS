package com.icg.serviceImpl;


import com.icg.dao.RolesDao;
import com.icg.daoImpl.RolesDaoImpl;
import com.icg.dto.ResponseModel;
import com.icg.service.RolesService;




public class RolesServiceImpl implements RolesService {

	 
	RolesDao rolesDao = new RolesDaoImpl();
	
	
	public ResponseModel getRoles(String userId) {
		// TODO Auto-generated method stub
		return rolesDao.getRoles(userId);
	}

}
