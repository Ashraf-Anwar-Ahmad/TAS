package com.icg.dao;

import com.icg.dto.CounterThreat;

public interface CounterDAO {

	public String add(CounterThreat threat);
	
	public CounterThreat findDataById(String id);
	
	public String update(CounterThreat threat);
}
