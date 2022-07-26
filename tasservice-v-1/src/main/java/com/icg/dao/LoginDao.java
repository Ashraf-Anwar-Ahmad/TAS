package com.icg.dao;

import com.icg.dto.ResponseModel;

public interface LoginDao {
	
	public ResponseModel getLogin(String userName, String password);
	public String validateUser(String... varArg);
}
