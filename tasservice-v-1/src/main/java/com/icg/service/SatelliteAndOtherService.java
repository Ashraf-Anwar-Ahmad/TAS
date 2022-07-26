package com.icg.service;

import com.icg.dto.SatelliteAndOther;

public interface SatelliteAndOtherService {

	 public String save(SatelliteAndOther threat);
		
		public SatelliteAndOther findById(String id);
		
		public String update(SatelliteAndOther threat);

		public String saveOther(SatelliteAndOther threat);

		public String updateOther(SatelliteAndOther threat);
}
