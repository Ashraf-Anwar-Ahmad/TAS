package com.icg.service;

import com.icg.dto.CounterThreat;

public interface CounterService {

	public String add(CounterThreat threat);
	
	public CounterThreat findDataById(String id);
	
	public String update(CounterThreat threat);
}
