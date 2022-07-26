package com.icg.service;

import com.icg.dto.ResponseModel;

public interface LoginService {
	
	public ResponseModel getLogin(String userName, String password);
	public String validateUser(String... varArg);
}
