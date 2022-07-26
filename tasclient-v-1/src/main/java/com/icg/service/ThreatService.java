package com.icg.service;

import java.util.List;

import com.icg.model.ContrabandThreat;
import com.icg.model.CounterThreat;
import com.icg.model.HumanTrafficing;
import com.icg.model.NarcoticThreat;
import com.icg.model.SatelliteAndOther;
import com.icg.model.ThreatCheck;
import com.icg.model.ThreatReceive;

public interface ThreatService {

	// below for Contraband
	public String add(ContrabandThreat threat);

	public ContrabandThreat findById(String id);

	public String update(ContrabandThreat threat);

	// below for CounterThreat
	public String addCounter(CounterThreat threat);

	public CounterThreat findCounterById(String id);

	public String updateCounter(CounterThreat threat);

	// below for NarcoticThreat
	public String addNarcotic(NarcoticThreat threat);

	public NarcoticThreat findNarcoticById(String id);

	public String updateNarcotic(NarcoticThreat threat);

	// below for alert check

	public List<ThreatReceive> getList(ThreatCheck threat);

	// Human trafficking
	public String save(HumanTrafficing threat);

	public HumanTrafficing findHumanTraffickingById(String id);

	public String updateHumanTrafficking(HumanTrafficing threat);

	// Satellight
	public String save(SatelliteAndOther threat);

	public SatelliteAndOther findSatelliteAndOtherById(String id);

	public String update(SatelliteAndOther threat);

	// Others
	public String saveOther(SatelliteAndOther threat);

	public String updateOther(SatelliteAndOther threat);

}
