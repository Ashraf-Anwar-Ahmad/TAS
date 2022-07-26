package com.icg.dao;

import com.icg.dto.SatelliteAndOther;

public interface SatelliteAndOtherDAO {

    public String save(SatelliteAndOther threat);
	
	public SatelliteAndOther findById(String id);
	
	public String update(SatelliteAndOther threat);

	String saveOther(SatelliteAndOther threat);

	String updateOther(SatelliteAndOther threat);
}
