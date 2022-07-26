package com.icg.serviceImpl;

import com.icg.dao.LoginDao;
import com.icg.daoImpl.LoginDaoImpl;
import com.icg.dto.ResponseModel;
import com.icg.service.LoginService;
/*
 * @RAJDEO
 * LOGIN SERVICE
 */
public class LoginServiceImpl implements LoginService{

	LoginDao loginDao=new LoginDaoImpl();
	
	public ResponseModel getLogin(String userName, String password) {
	return loginDao.getLogin(userName, password);	
	}
	public String validateUser(String... varArg)
	{
		return loginDao.validateUser(varArg);
	}
}
