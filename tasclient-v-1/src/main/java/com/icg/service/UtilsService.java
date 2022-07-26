package com.icg.service;

import java.util.List;


import com.icg.model.DropdownMaster;

public interface UtilsService {

	
	public List <DropdownMaster> getMaster(String id1,String id2);
	
	public String checkInputId(String inpuId);
	
}
