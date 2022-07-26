package com.icg.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.icg.dao.TestDAO;
import com.icg.daoImpl.TestDAOImpl;
import com.icg.dto.Test;
import com.icg.service.TestService;

public class TestServiceImpl implements TestService {

	@Autowired
	TestDAO test=new TestDAOImpl();
	
	
	public String add(Test testcl) {
		return test.add(testcl);
	}

}
