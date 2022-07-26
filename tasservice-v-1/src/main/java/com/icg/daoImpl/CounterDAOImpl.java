package com.icg.daoImpl;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icg.dao.CounterDAO;
import com.icg.dto.Ammunition;
import com.icg.dto.AmmunitionStr;
import com.icg.dto.Boat;
import com.icg.dto.BoatStr;
import com.icg.dto.Contact;
import com.icg.dto.CounterThreat;
import com.icg.dto.Crew;
import com.icg.dto.CrewStr;
import com.icg.dto.Imei;
import com.icg.dto.ImeiStr;
import com.icg.dto.Narcotic;
import com.icg.dto.Upload;
import com.icg.dto.Vessel;
import com.icg.dto.VesselStr;
import com.icg.utils.JdbcConnectionUtil;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;

public class CounterDAOImpl implements CounterDAO {

	ObjectMapper objectMapper;
	private int status = 0;
	private String response = null;

	public String add(CounterThreat threat) {
		objectMapper = new ObjectMapper();
		Connection con = JdbcConnectionUtil.getConnection();
		CallableStatement callableStatement = null;
		try {
			System.out.println("PR_SET_COUNTER_TERRORISM>>>> " + threat.toString());
			String groupAdd = "{call PR_SET_COUNTER_TERRORISM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			callableStatement = con.prepareCall(groupAdd);
			callableStatement.setString(1, "");
			callableStatement.setString(2, threat.getThreatTypeName());
			callableStatement.setString(3, threat.getInputId());
			callableStatement.setString(4, threat.getDateRecpt());
			callableStatement.setString(5, threat.getOrigntrName());
			callableStatement.setString(6, threat.getOrigntrOther());
			callableStatement.setString(7, threat.getTimeOfPos());
			callableStatement.setString(8, threat.getTimeOfActivation());
			callableStatement.setString(9, threat.getGradingName());
			callableStatement.setString(10, threat.getGpslattitudeDec());
			callableStatement.setString(11, threat.getGpslongitudeDec());
			callableStatement.setString(12, threat.getGpslattitudeDeg());
			callableStatement.setString(13, threat.getGpslongitudeDeg());
			callableStatement.setString(14, threat.getDistanceKmLnd());
			callableStatement.setString(15, threat.getDistanceMileLnd());
			callableStatement.setString(16, threat.getLocation());
			callableStatement.setString(17, threat.getRegionName());
			callableStatement.setString(18, threat.getCoastStatName());
			if (threat.getImeiList().size() == 0) {
				callableStatement.setString(19, "No");
			} else {
				callableStatement.setString(19, "Yes");
			}
			callableStatement.setString(20, threat.getNameSuspects());
			// for array of SharedWithName
			Array arraySharedWithName = ((OracleConnection) con).createOracleArray("TAS.SHARED_WITH",
					threat.getSharedWithName().toArray());
			callableStatement.setArray(21, arraySharedWithName);
			callableStatement.setString(22, threat.getSharedWithOther());
			Array array_to_pass = ((OracleConnection) con).createOracleArray("TAS.UNITS_INV",
					threat.getIcgUnitsName().toArray());
			callableStatement.setArray(23, array_to_pass);
			callableStatement.setString(24, threat.getApplattitudeDec());
			callableStatement.setString(25, threat.getApplongitudeDec());
			callableStatement.setString(26, threat.getApplattitudeDeg());
			callableStatement.setString(27, threat.getApplongitudeDeg());

			// for Contact Details
			List<Contact> cntctDtls = threat.getContactList();
			int i = 0;
			Struct[] structArrayContact = new Struct[cntctDtls.size()];

			for (Contact cnt : cntctDtls) {
				Object[] check1 = new Object[] { cnt.getCntctId(), cnt.getContactNo(), cnt.getCountry(),
						cnt.getGnCountryCode(), };
				Struct structContact = con.createStruct("CONTACT_DTLS", check1);
				structArrayContact[i] = structContact;
				i++;
			}
			Array arrayOfContact = ((OracleConnection) con).createOracleArray("CONTACT_DTLS_ARRAY", structArrayContact);

			// for Crew

			List<Crew> crewList = threat.getCrewList();
			int l = 0;
			Struct[] structArrayCrew = new Struct[crewList.size()];
			for (Crew cnt : crewList) {
				Object[] check1 = new Object[] 
						{ 
								cnt.getCrId(), 
								cnt.getCrName(), 
								cnt.getCrAge(), 
								cnt.getCrNationality(),
								cnt.getCrAddress(), 
								cnt.getCrTelNo(), 
								cnt.getCrMartSts(), 
								cnt.getCrProfession(),
								cnt.getCrIdenMrks(), 
								cnt.getCrRelgn(), 
								cnt.getCrDtlsIdType(), 
								cnt.getCrDtlsIdPf(),
								cnt.getCrCountCode(), 
						};
				Struct structCrew = con.createStruct("CREW_DTLS", check1);
				structArrayCrew[l] = structCrew;
				l++;
			}
			Array arrayOfCrew = ((OracleConnection) con).createOracleArray("CREW_ARRAY", structArrayCrew);

			// for Ammunition

			List<Ammunition> ammunitionList = threat.getAmmunitionList();
			int j = 0;
			Struct[] structArrayAmmunition = new Struct[ammunitionList.size()];
			for (Ammunition cnt : ammunitionList) {
				Object[] check1 = new Object[] 
						{ 
								cnt.getAmmunId(), 
								cnt.getTypeAmmun(), 
								cnt.getAmmunQty(),
								cnt.getAmmunMake(), 
								cnt.getAmmunModel(), 
								cnt.getAmmunManuCntry(), 
								cnt.getAmmunRmks(),
								cnt.getArmsDetails(), 
								cnt.getAmmdetails(), 
								cnt.getAmmuUnit() 
						};
				Struct structAmmunition = con.createStruct("AMMUN_DTLS", check1);
				structArrayAmmunition[j] = structAmmunition;
				j++;
			}
			Array arrayOfAmmunition = ((OracleConnection) con).createOracleArray("AMMUN_DTLS_ARRAY",
					structArrayAmmunition);

			if (threat.getContactList().size() == 0) {
				callableStatement.setString(28, "No");
			} else {
				callableStatement.setString(28, "Yes");
			}

			callableStatement.setArray(29, arrayOfContact);

			if (threat.getCrewList().size() == 0) {
				callableStatement.setString(30, "No");
			} else {
				callableStatement.setString(30, "Yes");
			}

			callableStatement.setArray(31, arrayOfCrew);

			if (threat.getAmmunitionList().size() == 0) {
				callableStatement.setString(32, "No");
			} else {
				callableStatement.setString(32, "Yes");
			}

			callableStatement.setArray(33, arrayOfAmmunition);
			callableStatement.setString(34, threat.getOtherInfo());
			callableStatement.setString(35, threat.getFollowUp());

			// below will change
			callableStatement.setString(36, "No");
			// for Crew

			List<Upload> uploadList = new ArrayList<Upload>();
			int m = 0;
			Struct[] structArrayUpload = new Struct[uploadList.size()];
			for (Upload cnt : uploadList) {
				Object[] check1 = new Object[] { "", "", "" };
				Struct structUpload = con.createStruct("OTHER_DTLS", check1);
				structArrayUpload[m] = structUpload;
				m++;
			}
			Array arrayOfUpload = ((OracleConnection) con).createOracleArray("OTHER_DTLS_ARRAY", structArrayUpload);

			// above will change

			callableStatement.setArray(37, arrayOfUpload);
			callableStatement.setString(38, threat.getFromWhere());

			// for imei
			List<Imei> imeiList = threat.getImeiList();
			int mp = 0;
			Struct[] structArrayImei = new Struct[imeiList.size()];
			for (Imei cnte : imeiList) {
				Object[] check1 = new Object[] { cnte.getImeiId(), cnte.getImei()

				};
				Struct structImei = con.createStruct("IMEI_DTLS", check1);
				structArrayImei[mp] = structImei;
				mp++;
			}
			Array arrayOfImei = ((OracleConnection) con).createOracleArray("IMEI_ARRAY", structArrayImei);

			callableStatement.setArray(39, arrayOfImei);

			// for Boats
			List<Boat> boatList = threat.getBoatList();
			int jm = 0;
			Struct[] structArrayBoat = new Struct[boatList.size()];
			for (Boat cnt : boatList) {
				Object[] check1 = new Object[] 
						{ 
								cnt.getBoatId(), 
								cnt.getBoatName(), 
								cnt.getRegNum(),
								cnt.getOwnerName(), 
								cnt.getStateReg(), 
								cnt.getPortReg(), 
								cnt.getNoOfCrew(), 
								cnt.getDocHeld(),
								cnt.getNavEqpt(), 
								cnt.getCommEqpt(), 
								cnt.getLifeEqpt(), 
								cnt.getBoatlpc(), 
								cnt.getBoatetd(),
								cnt.getBoatnpc(), 
								cnt.getBoateta(), 
								cnt.getLicenseFish(), 
								cnt.getOwnerContDts(),
								cnt.getBoatColrcd(), 
								cnt.getRemarks(), 
								cnt.gettypeOfBoat(), 
								cnt.getownerContCode(), 
						};
				Struct structBoat = con.createStruct("BOAT_DTLS", check1);
				structArrayBoat[jm] = structBoat;
				jm++;
			}
			Array arrayOfBoat = ((OracleConnection) con).createOracleArray("BOAT_DTLS_ARRAY", structArrayBoat);

			// for vessel

			List<Vessel> vesselList = threat.getVesselList();

			int k = 0;
			Struct[] structArrayVessel = new Struct[vesselList.size()];
			for (Vessel cnt : vesselList) {
				Object[] check1 = new Object[] 
						{ 
								cnt.getVesselId(), 
								cnt.getVesselName(), 
								cnt.getVesselTypeName(),
								cnt.getIntCallSign(), 
								cnt.getMmsi(), 
								cnt.getImoNo(), 
								cnt.getCargo(), 
								cnt.getVessellpc(),
								cnt.getVesseletd(), 
								cnt.getVesselnpc(), 
								cnt.getVesseleta(), 
								cnt.getTotCrew(),
								cnt.getFlgPrtReg(), 
								cnt.getInmarsatNo(), 
								cnt.getOtherCommEqpt(), 
								cnt.getAgent(),
								cnt.getPans() 
						};
				Struct structVessel = con.createStruct("VESSEL_DTLS", check1);
				structArrayVessel[k] = structVessel;
				k++;
			}
			Array arrayOfVessel = ((OracleConnection) con).createOracleArray("VESSEL_DTLS_ARRAY", structArrayVessel);

			if (threat.getBoatList().size() == 0) {
				callableStatement.setString(40, "No");
			} else {
				callableStatement.setString(40, "Yes");
			}

			callableStatement.setArray(41, arrayOfBoat);

			if (threat.getVesselList().size() == 0) {
				callableStatement.setString(42, "No");
			} else {
				callableStatement.setString(42, "Yes");
			}

			callableStatement.setArray(43, arrayOfVessel);
			callableStatement.setString(44, threat.getOtherUnit());
			callableStatement.registerOutParameter(45, OracleTypes.VARCHAR);
			status = callableStatement.executeUpdate();
			response = callableStatement.getString(45);
			System.out.println("response=====" + response);

		} catch (Exception e) {
			e.printStackTrace();
			response = "Failure";
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
				if (con != null) {
					System.out.println("in finally add counter terrorism, for close!!");
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return response;
	}

	@Override
	public CounterThreat findDataById(String id) {
		CounterThreat threat = new CounterThreat();
		Connection con = JdbcConnectionUtil.getConnection();
		ResultSet rset = null;
		CallableStatement callableStatement = null;
		try {
			String procedure = "{call PR_GET_THREAT_DATA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			callableStatement = con.prepareCall(procedure);

			callableStatement.setString(1, id);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR); // General details cursor
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR); // Contact Details cursor
			callableStatement.registerOutParameter(4, OracleTypes.CURSOR); // Threat type(smuggling) details cursor
			callableStatement.registerOutParameter(5, OracleTypes.CURSOR); // Boat deatils cursor
			callableStatement.registerOutParameter(6, OracleTypes.CURSOR); // Vessel details cursor
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR); // Crew details cursor
			callableStatement.registerOutParameter(8, OracleTypes.CURSOR); // Passenger details cursor
			callableStatement.registerOutParameter(9, OracleTypes.CURSOR); // Ammunition details cursor
			callableStatement.registerOutParameter(10, OracleTypes.CURSOR); // Other info cursor
			callableStatement.registerOutParameter(11, OracleTypes.CURSOR); // Units involved cursor
			callableStatement.registerOutParameter(12, OracleTypes.CURSOR); // Narcotics details cursor
			callableStatement.registerOutParameter(13, OracleTypes.CURSOR);
			callableStatement.registerOutParameter(14, OracleTypes.CURSOR); // Shared With details cursor

			callableStatement.registerOutParameter(15, OracleTypes.VARCHAR);

			callableStatement.executeUpdate();

			rset = (ResultSet) callableStatement.getObject(2);
			while (rset.next()) {
				threat.setThreatId(rset.getString(1));
				threat.setThreatTypeId(rset.getString(2));
				threat.setThreatTypeName(rset.getString(3));
				threat.setInputId(rset.getString(4));
				threat.setDateRecpt(rset.getString(5));
				threat.setOrigntrId(rset.getString(6));
				threat.setOrigntrName(rset.getString(7));
				threat.setTimeOfPos(rset.getString(8));
				threat.setTimeOfActivation(rset.getString(9));
				threat.setGradingId(rset.getString(10));
				threat.setGradingName(rset.getString(11));
				threat.setGpslattitudeDec(rset.getString(12));
				threat.setGpslongitudeDec(rset.getString(13));
				threat.setGpslattitudeDeg(rset.getString(14));
				threat.setGpslongitudeDeg(rset.getString(15));
				threat.setDistanceKmLnd(rset.getString(16));
				threat.setDistanceMileLnd(rset.getString(17));
				threat.setLocation(rset.getString(18));// location id
				threat.setRegionId(rset.getString(19));
				threat.setRegionName(rset.getString(20));
				threat.setCoastStatId(rset.getString(21));
				threat.setCoastStatName(rset.getString(22));
				// threat.setImeiNo(rset.getString(23));
				threat.setNameSuspects(rset.getString(24));
				threat.setSharedWithId(rset.getString(25));

				// isko change krna hai
				// threat.setSharedWithName(rset.getString(26));
				threat.setOtherInfo(rset.getString(27));
				threat.setFollowUp(rset.getString(28));
				threat.setFromWhere(rset.getString(29));// (0406)
				threat.setLocationName(rset.getString(30));// (0406)
				// threat.setFollowUp(rset.getString(31));
				// threat.setFromWhere(rset.getString(32));// (0406)
				threat.setOtherUnit(rset.getString(33));// (0406)
			}

			rset = null;
			rset = (ResultSet) callableStatement.getObject(3);
			List<Contact> contactList = getContactList(rset);
			threat.setContactList(contactList);

			rset = null;
			rset = (ResultSet) callableStatement.getObject(4);
			while (rset.next()) {
				threat.setApplattitudeDec(rset.getString(16));
				threat.setApplongitudeDec(rset.getString(17));
				threat.setApplattitudeDeg(rset.getString(18));
				threat.setApplongitudeDeg(rset.getString(19));
			}

			// below for boats
			rset = null;
			rset = (ResultSet) callableStatement.getObject(5);
			BoatStr btst = getBoatList(rset);
			threat.setBoatList(btst.getBoatList());
			threat.setBoatStrList(btst.getBoatStrList());

			// below for vessels
			rset = null;
			rset = (ResultSet) callableStatement.getObject(6);
			VesselStr vslst = getVesselList(rset);
			threat.setVesselList(vslst.getVesselList());
			threat.setVesselStrList(vslst.getVesselStrList());

			// below for ammunition
			rset = null;
			rset = (ResultSet) callableStatement.getObject(9);
			AmmunitionStr amnst = getAmmunitionList(rset);
			threat.setAmmunitionList(amnst.getAmmunitionList());
			threat.setAmmunitionStrList(amnst.getAmmunitionStrList());

			// below for contacts
			rset = null;
			rset = (ResultSet) callableStatement.getObject(7);
			CrewStr crwlst = getCrewList(rset);
			threat.setCrewList(crwlst.getCrewList());
			threat.setCrewStrList(crwlst.getCrewStrList());

			rset = null;
			rset = (ResultSet) callableStatement.getObject(10);
			while (rset.next()) {

			}

			rset = null;
			rset = (ResultSet) callableStatement.getObject(11);
			ArrayList<String> untLst = new ArrayList<String>();
			while (rset.next()) {
				String str = rset.getString(1);
				if (str != null && !str.isEmpty()) {
					untLst.add(str);
				}
			}
			threat.setIcgUnitsName(untLst);

			rset = null;
			rset = (ResultSet) callableStatement.getObject(13);// changed 24/06/2022
			ImeiStr imeilst = getImeiList(rset);
			threat.setImeiList(imeilst.getImeiList());
			threat.setImeiStrList(imeilst.getImeiStrList());

			rset = null;
			rset = (ResultSet) callableStatement.getObject(14);
			ArrayList<String> sharedWithNameLst = new ArrayList<String>();
			while (rset.next()) {
				String str = rset.getString(1);
				if (str != null && !str.isEmpty()) {
					sharedWithNameLst.add(str);
				}
			}
			threat.setSharedWithName(sharedWithNameLst);
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
				if (con != null) {
					System.out.println("in finally view details counter terrorism, for close!!");
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return threat;
	}

	// Extra Method

	public ImeiStr getImeiList(ResultSet rset) throws SQLException {
		List<Imei> list = new ArrayList<Imei>();
		List<List<String>> imeiStrList = new ArrayList<List<String>>();
		while (rset.next()) {
			Imei imei = new Imei();
			List<String> ImeiStr = new ArrayList<String>();
			imei.setImeiId(rset.getString(1));
			ImeiStr.add(rset.getString(1));
			imei.setImei(rset.getString(2));
			ImeiStr.add(rset.getString(2));

			list.add(imei);
			imeiStrList.add(ImeiStr);
		}
		ImeiStr bt1 = new ImeiStr();
		bt1.setImeiList(list);
		bt1.setImeiStrList(imeiStrList);
		return bt1;
	}

	public List<Contact> getContactList(ResultSet rset) throws SQLException {
		List<Contact> list = new ArrayList<Contact>();
		while (rset.next()) {
			Contact contact = new Contact();
			contact.setCntctId(rset.getString(1));
			contact.setContactNo(rset.getString(2));
			contact.setCountry(rset.getString(3));
			contact.setGnCountryCode(rset.getString(4));
			list.add(contact);
		}
		return list;
	}

	public List<Narcotic> getNarcoticList(ResultSet rset) throws SQLException {
		List<Narcotic> list = new ArrayList<Narcotic>();
		while (rset.next()) {
			Narcotic narco = new Narcotic();
			narco.setNarcoId(rset.getString(1));
			narco.setNarcoTypeId(rset.getString(2));
			narco.setNarcoTypeName(rset.getString(3));
			narco.setNarcoQty(rset.getString(4));
			narco.setNarcoUnit(rset.getString(5));
			narco.setNarcoUnitDescr(rset.getString(6));
			list.add(narco);
		}
		return list;
	}

	public BoatStr getBoatList(ResultSet rset) throws SQLException {
		List<Boat> list = new ArrayList<Boat>();
		List<List<String>> botStrList = new ArrayList<List<String>>();

		while (rset.next()) {
			Boat boat = new Boat();
			List<String> boatStr = new ArrayList<String>();
			boat.setBoatId(rset.getString(1));
			boat.setBoatName(rset.getString(2));
			boatStr.add(rset.getString(2));
			boat.setRegNum(rset.getString(3));
			boatStr.add(rset.getString(3));
			boat.setOwnerName(rset.getString(4));
			boatStr.add(rset.getString(4));
			boat.setPortReg(rset.getString(5));
			boatStr.add(rset.getString(5));
			boat.setNoOfCrew(rset.getString(6));
			boatStr.add(rset.getString(6));
			boat.setDocHeld(rset.getString(7));
			boatStr.add(rset.getString(7));
			boat.setNavEqpt(rset.getString(8));
			boatStr.add(rset.getString(8));
			boat.setCommEqpt(rset.getString(9));
			boatStr.add(rset.getString(9));
			boat.setLifeEqpt(rset.getString(10));
			boatStr.add(rset.getString(10));
			boat.setBoatlpc(rset.getString(11));
			boatStr.add(rset.getString(11));
			boat.setBoatetd(rset.getString(12));
			boatStr.add(rset.getString(12));
			boat.setBoatnpc(rset.getString(13));
			boatStr.add(rset.getString(13));
			boat.setBoateta(rset.getString(14));
			boatStr.add(rset.getString(14));
			boat.setLicenseFish(rset.getString(15));
			boatStr.add(rset.getString(15));
			boat.setOwnerContDts(rset.getString(16));
			boatStr.add(rset.getString(16));
			boat.setBoatColrcd(rset.getString(17));
			boatStr.add(rset.getString(17));
			boat.setRemarks(rset.getString(18));
			boatStr.add(rset.getString(18));

			boat.settypeOfBoat(rset.getString(19));
			boatStr.add(rset.getString(19));
			boat.setTypeOfBoatName(rset.getString(20));
			boatStr.add(rset.getString(20));
			boat.setOwnerContCode(rset.getString(21));
			boatStr.add(rset.getString(21));
			boat.setStateReg(rset.getString(22));
			boatStr.add(rset.getString(22));

			boatStr.add(rset.getString(1));
			list.add(boat);
			botStrList.add(boatStr);
		}
		BoatStr bt = new BoatStr();
		bt.setBoatList(list);
		bt.setBoatStrList(botStrList);
		return bt;
	}

	public VesselStr getVesselList(ResultSet rset) throws SQLException {
		List<Vessel> list = new ArrayList<Vessel>();
		List<List<String>> vslStrList = new ArrayList<List<String>>();

		while (rset.next()) {
			Vessel vessel = new Vessel();
			List<String> vesselStr = new ArrayList<String>();
			vessel.setVesselId(rset.getString(1));
			vessel.setVesselName(rset.getString(2));
			vesselStr.add(rset.getString(2));
			vessel.setVesselTypeId(rset.getString(3));
			vesselStr.add(rset.getString(3));
			vessel.setVesselTypeName(rset.getString(4));
			vessel.setIntCallSign(rset.getString(5));
			vesselStr.add(rset.getString(5));
			vessel.setMmsi(rset.getString(6));
			vesselStr.add(rset.getString(6));
			vessel.setImoNo(rset.getString(7));
			vesselStr.add(rset.getString(7));
			vessel.setCargo(rset.getString(8));
			vesselStr.add(rset.getString(8));
			vessel.setVessellpc(rset.getString(9));
			vesselStr.add(rset.getString(9));
			vessel.setVesseletd(rset.getString(10));
			vesselStr.add(rset.getString(10));
			vessel.setVesselnpc(rset.getString(11));
			vesselStr.add(rset.getString(11));
			vessel.setVesseleta(rset.getString(12));
			vesselStr.add(rset.getString(12));
			vessel.setTotCrew(rset.getString(13));
			vesselStr.add(rset.getString(13));
			vessel.setFlgPrtReg(rset.getString(14));
			vesselStr.add(rset.getString(14));
			vessel.setInmarsatNo(rset.getString(15));
			vesselStr.add(rset.getString(15));
			vessel.setOtherCommEqpt(rset.getString(16));
			vesselStr.add(rset.getString(16));
			vessel.setAgent(rset.getString(17));
			vesselStr.add(rset.getString(17));
			vessel.setPans(rset.getString(18));
			vesselStr.add(rset.getString(18));
			vesselStr.add(rset.getString(1));
			list.add(vessel);
			vslStrList.add(vesselStr);
		}
		VesselStr bt1 = new VesselStr();
		bt1.setVesselList(list);
		bt1.setVesselStrList(vslStrList);
		return bt1;
	}

	// below for ammunition
	public AmmunitionStr getAmmunitionList(ResultSet rset) throws SQLException {
		List<Ammunition> list = new ArrayList<Ammunition>();
		List<List<String>> amnStrList = new ArrayList<List<String>>();

		while (rset.next()) {
			Ammunition ammunition = new Ammunition();
			List<String> ammunStr = new ArrayList<String>();

			ammunition.setAmmunId(rset.getString(1));
			ammunition.setTypeAmmun(rset.getString(2));
			ammunStr.add(rset.getString(2));
			ammunition.setAmmunQty(rset.getString(3));
			ammunStr.add(rset.getString(3));
			ammunition.setAmmuUnit(rset.getString(4));
			ammunStr.add(rset.getString(4));
			ammunition.setAmmuUnitName(rset.getString(5));
			ammunStr.add(rset.getString(5));
			ammunition.setAmmunMake(rset.getString(6));
			ammunStr.add(rset.getString(6));
			ammunition.setAmmunModel(rset.getString(7));
			ammunStr.add(rset.getString(7));
			ammunition.setAmmunManuCntry(rset.getString(8));
			ammunStr.add(rset.getString(8));

			ammunition.setArmsDetails(rset.getString(9));
			ammunStr.add(rset.getString(9));
			ammunition.setAmmdetails(rset.getString(10));
			ammunStr.add(rset.getString(10));
			ammunition.setAmmunRmks(rset.getString(11));
			ammunStr.add(rset.getString(11));
			ammunStr.add(rset.getString(1));
			list.add(ammunition);
			amnStrList.add(ammunStr);
		}
		AmmunitionStr bt1 = new AmmunitionStr();
		bt1.setAmmunitionList(list);
		bt1.setAmmunitionStrList(amnStrList);
		return bt1;
	}

	public CrewStr getCrewList(ResultSet rset) throws SQLException {
		List<Crew> list = new ArrayList<Crew>();
		List<List<String>> crwStrList = new ArrayList<List<String>>();
		while (rset.next()) {
			Crew crew = new Crew();
			List<String> CrewStr = new ArrayList<String>();
			crew.setCrId(rset.getString(1));
			crew.setCrName(rset.getString(2));
			CrewStr.add(rset.getString(2));
			crew.setCrAge(rset.getString(3));
			CrewStr.add(rset.getString(3));
			crew.setCrNationality(rset.getString(4));
			CrewStr.add(rset.getString(4));
			crew.setCrAddress(rset.getString(5));
			CrewStr.add(rset.getString(5));
			crew.setCrTelNo(rset.getString(6));
			CrewStr.add(rset.getString(6));
			crew.setCrMartStsId(rset.getString(7));
			crew.setCrMartSts(rset.getString(8));
			CrewStr.add(rset.getString(7));
			crew.setCrProfession(rset.getString(9));
			CrewStr.add(rset.getString(9));
			crew.setCrIdenMrks(rset.getString(10));
			CrewStr.add(rset.getString(10));
			crew.setCrRelgnId(rset.getString(11));
			crew.setCrRelgn(rset.getString(12));
			CrewStr.add(rset.getString(11));
			crew.setCrDtlsIdPf(rset.getString(13));
			CrewStr.add(rset.getString(13));

			crew.setCrDtlsIdType(rset.getString(14));
			CrewStr.add(rset.getString(14));
			crew.setCrDtlsIdTypeName(rset.getString(15));
			CrewStr.add(rset.getString(15));
			crew.setCrCountCode(rset.getString(16));
			CrewStr.add(rset.getString(16));
			CrewStr.add(rset.getString(1));

			list.add(crew);
			crwStrList.add(CrewStr);
		}
		CrewStr bt1 = new CrewStr();
		bt1.setCrewList(list);
		bt1.setCrewStrList(crwStrList);
		return bt1;
	}

	public CrewStr getPassengerList(ResultSet rset) throws SQLException {
		List<Crew> list = new ArrayList<Crew>();
		List<List<String>> crwStrList = new ArrayList<List<String>>();
		while (rset.next()) {
			Crew crew = new Crew();
			List<String> CrewStr = new ArrayList<String>();
			crew.setCrId(rset.getString(1));
			crew.setCrName(rset.getString(2));
			CrewStr.add(rset.getString(2));
			crew.setCrAge(rset.getString(3));
			CrewStr.add(rset.getString(3));

			crew.setGender(rset.getString(4));
			CrewStr.add(rset.getString(4));
			crew.setGenderDpsc(rset.getString(5));

			crew.setCrNationality(rset.getString(6));
			CrewStr.add(rset.getString(6));
			crew.setCrAddress(rset.getString(7));
			CrewStr.add(rset.getString(7));
			crew.setCrTelNo(rset.getString(8));
			CrewStr.add(rset.getString(8));

			crew.setCrMartStsId(rset.getString(9));
			crew.setCrMartSts(rset.getString(10));
			CrewStr.add(rset.getString(9));
			crew.setCrProfession(rset.getString(11));
			CrewStr.add(rset.getString(11));
			crew.setCrIdenMrks(rset.getString(12));
			CrewStr.add(rset.getString(12));
			crew.setCrRelgnId(rset.getString(13));
			crew.setCrRelgn(rset.getString(14));
			CrewStr.add(rset.getString(13));

			CrewStr.add(rset.getString(1));

			list.add(crew);
			crwStrList.add(CrewStr);
		}
		CrewStr bt1 = new CrewStr();
		bt1.setCrewList(list);
		bt1.setCrewStrList(crwStrList);
		return bt1;
	}

	public String update(CounterThreat threat) {
		objectMapper = new ObjectMapper();
		Connection con = JdbcConnectionUtil.getConnection();
		CallableStatement callableStatement = null;
		try {
			System.out.println(threat.getThreatId() + " PR_SET_COUNTER_TERRORISM");
			String groupAdd = "{call PR_SET_COUNTER_TERRORISM(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			callableStatement = con.prepareCall(groupAdd);
			callableStatement.setString(1, threat.getThreatId());
			callableStatement.setString(2, threat.getThreatTypeName());
			callableStatement.setString(3, threat.getInputId());
			callableStatement.setString(4, threat.getDateRecpt());
			callableStatement.setString(5, threat.getOrigntrName());
			callableStatement.setString(6, threat.getOrigntrOther());
			callableStatement.setString(7, threat.getTimeOfPos());
			callableStatement.setString(8, threat.getTimeOfActivation());
			callableStatement.setString(9, threat.getGradingName());
			callableStatement.setString(10, threat.getGpslattitudeDec());
			callableStatement.setString(11, threat.getGpslongitudeDec());
			callableStatement.setString(12, threat.getGpslattitudeDeg());
			callableStatement.setString(13, threat.getGpslongitudeDeg());
			callableStatement.setString(14, threat.getDistanceKmLnd());
			callableStatement.setString(15, threat.getDistanceMileLnd());
			callableStatement.setString(16, threat.getLocation());
			callableStatement.setString(17, threat.getRegionName());
			callableStatement.setString(18, threat.getCoastStatName());
			if (threat.getImeiList().size() == 0) {
				callableStatement.setString(19, "No");
			} else {
				callableStatement.setString(19, "Yes");
			}
			callableStatement.setString(20, threat.getNameSuspects());
			// for array of SharedWithName
			Array arraySharedWithName = ((OracleConnection) con).createOracleArray("TAS.SHARED_WITH",
					threat.getSharedWithName().toArray());
			callableStatement.setArray(21, arraySharedWithName);
			callableStatement.setString(22, threat.getSharedWithOther());
			Array array_to_pass = ((OracleConnection) con).createOracleArray("TAS.UNITS_INV",
					threat.getIcgUnitsName().toArray());
			callableStatement.setArray(23, array_to_pass);
			callableStatement.setString(24, threat.getApplattitudeDec());
			callableStatement.setString(25, threat.getApplongitudeDec());
			callableStatement.setString(26, threat.getApplattitudeDeg());
			callableStatement.setString(27, threat.getApplongitudeDeg());

			// for Contact Details
			List<Contact> cntctDtls = threat.getContactList();
			int i = 0;
			Struct[] structArrayContact = new Struct[cntctDtls.size()];

			for (Contact cnt : cntctDtls) {
				Object[] check1 = new Object[] { cnt.getCntctId(), cnt.getContactNo(), cnt.getCountry(),
						cnt.getGnCountryCode(), };
				Struct structContact = con.createStruct("CONTACT_DTLS", check1);
				structArrayContact[i] = structContact;
				i++;
			}
			Array arrayOfContact = ((OracleConnection) con).createOracleArray("CONTACT_DTLS_ARRAY", structArrayContact);

			// for Crew

			List<Crew> crewList = threat.getCrewList();
			int l = 0;
			Struct[] structArrayCrew = new Struct[crewList.size()];
			for (Crew cnt : crewList) {
				Object[] check1 = new Object[] 
						{ 
								cnt.getCrId(),
								cnt.getCrName(), 
								cnt.getCrAge(), 
								cnt.getCrNationality(),	
								cnt.getCrAddress(), 
								cnt.getCrTelNo(), 
								cnt.getCrMartStsId(), 
								cnt.getCrProfession(),
								cnt.getCrIdenMrks(), 
								cnt.getCrRelgnId(), 
								cnt.getCrDtlsIdType(), 
								cnt.getCrDtlsIdPf(),
								cnt.getCrCountCode(),
						};
				Struct structCrew = con.createStruct("CREW_DTLS", check1);
				structArrayCrew[l] = structCrew;
				l++;
			}
			Array arrayOfCrew = ((OracleConnection) con).createOracleArray("CREW_ARRAY", structArrayCrew);

			// for Ammunition

			List<Ammunition> ammunitionList = threat.getAmmunitionList();
			int j = 0;
			Struct[] structArrayAmmunition = new Struct[ammunitionList.size()];
			for (Ammunition cnt : ammunitionList) {
				Object[] check1 = new Object[] 
						{ 
								cnt.getAmmunId(), 
								cnt.getTypeAmmun(), 
								cnt.getAmmunQty(),
								cnt.getAmmunMake(), 
								cnt.getAmmunModel(), 
								cnt.getAmmunManuCntry(), 
								cnt.getAmmunRmks(),
								cnt.getArmsDetails(), 
								cnt.getAmmdetails(), 
								cnt.getAmmuUnit() 
						};
				Struct structAmmunition = con.createStruct("AMMUN_DTLS", check1);
				structArrayAmmunition[j] = structAmmunition;
				j++;
			}
			Array arrayOfAmmunition = ((OracleConnection) con).createOracleArray("AMMUN_DTLS_ARRAY",
					structArrayAmmunition);

			if (threat.getContactList().size() == 0) {
				callableStatement.setString(28, "No");
			} else {
				callableStatement.setString(28, "Yes");
			}

			callableStatement.setArray(29, arrayOfContact);

			if (threat.getCrewList().size() == 0) {
				callableStatement.setString(30, "No");
			} else {
				callableStatement.setString(30, "Yes");
			}

			callableStatement.setArray(31, arrayOfCrew);

			if (threat.getAmmunitionList().size() == 0) {
				callableStatement.setString(32, "No");
			} else {
				callableStatement.setString(32, "Yes");
			}

			callableStatement.setArray(33, arrayOfAmmunition);
			callableStatement.setString(34, threat.getOtherInfo());
			callableStatement.setString(35, threat.getFollowUp());

			// below will change
			callableStatement.setString(36, "No");
			// for Crew

			List<Upload> uploadList = new ArrayList<Upload>();
			int m = 0;
			Struct[] structArrayUpload = new Struct[uploadList.size()];
			for (Upload cnt : uploadList) {
				Object[] check1 = new Object[] { "", "", "" };
				Struct structUpload = con.createStruct("OTHER_DTLS", check1);
				structArrayUpload[m] = structUpload;
				m++;
			}
			Array arrayOfUpload = ((OracleConnection) con).createOracleArray("OTHER_DTLS_ARRAY", structArrayUpload);

			// above will change

			callableStatement.setArray(37, arrayOfUpload);
			callableStatement.setString(38, threat.getFromWhere());

			// for imei
			List<Imei> imeiList = threat.getImeiList();
			int mp = 0;
			Struct[] structArrayImei = new Struct[imeiList.size()];
			for (Imei cnte : imeiList) {
				Object[] check1 = new Object[] { cnte.getImeiId(), cnte.getImei()

				};
				Struct structImei = con.createStruct("IMEI_DTLS", check1);
				structArrayImei[mp] = structImei;
				mp++;
			}
			Array arrayOfImei = ((OracleConnection) con).createOracleArray("IMEI_ARRAY", structArrayImei);

			callableStatement.setArray(39, arrayOfImei);

			// for Boats
			List<Boat> boatList = threat.getBoatList();
			int jm = 0;
			Struct[] structArrayBoat = new Struct[boatList.size()];
			for (Boat cnt : boatList) {
				Object[] check1 = new Object[] 
						{ 
								cnt.getBoatId(), 
								cnt.getBoatName(), 
								cnt.getRegNum(),
								cnt.getOwnerName(), 
								cnt.getStateReg(), 
								cnt.getPortReg(), 
								cnt.getNoOfCrew(), 
								cnt.getDocHeld(),
								cnt.getNavEqpt(), 
								cnt.getCommEqpt(), 
								cnt.getLifeEqpt(), 
								cnt.getBoatlpc(), 
								cnt.getBoatetd(),
								cnt.getBoatnpc(), 
								cnt.getBoateta(), 
								cnt.getLicenseFish(), 
								cnt.getOwnerContDts(),
								cnt.getBoatColrcd(), 
								cnt.getRemarks(), 
								cnt.gettypeOfBoat(), 
								cnt.getownerContCode(), 
						};
				Struct structBoat = con.createStruct("BOAT_DTLS", check1);
				structArrayBoat[jm] = structBoat;
				jm++;
			}
			Array arrayOfBoat = ((OracleConnection) con).createOracleArray("BOAT_DTLS_ARRAY", structArrayBoat);

			// for vessel

			List<Vessel> vesselList = threat.getVesselList();

			int k = 0;
			Struct[] structArrayVessel = new Struct[vesselList.size()];
			for (Vessel cnt : vesselList) {
				Object[] check1 = new Object[] 
						{ 
								cnt.getVesselId(), 
								cnt.getVesselName(), 
								cnt.getVesselTypeName(),
								cnt.getIntCallSign(), 
								cnt.getMmsi(), 
								cnt.getImoNo(), 
								cnt.getCargo(), 
								cnt.getVessellpc(),
								cnt.getVesseletd(), 
								cnt.getVesselnpc(), 
								cnt.getVesseleta(), 
								cnt.getTotCrew(),
								cnt.getFlgPrtReg(), 
								cnt.getInmarsatNo(), 
								cnt.getOtherCommEqpt(), 
								cnt.getAgent(),
								cnt.getPans() 
						};
				Struct structVessel = con.createStruct("VESSEL_DTLS", check1);
				structArrayVessel[k] = structVessel;
				k++;
			}
			Array arrayOfVessel = ((OracleConnection) con).createOracleArray("VESSEL_DTLS_ARRAY", structArrayVessel);

			if (threat.getBoatList().size() == 0) {
				callableStatement.setString(40, "No");
			} else {
				callableStatement.setString(40, "Yes");
			}

			callableStatement.setArray(41, arrayOfBoat);

			if (threat.getVesselList().size() == 0) {
				callableStatement.setString(42, "No");
			} else {
				callableStatement.setString(42, "Yes");
			}

			callableStatement.setArray(43, arrayOfVessel);
			callableStatement.setString(44, threat.getOtherUnit());
			callableStatement.registerOutParameter(45, OracleTypes.VARCHAR);
			status = callableStatement.executeUpdate();
			response = callableStatement.getString(45);
			System.out.println("response=====" + response);
		} catch (Exception e) {
			e.printStackTrace();
			response = "Failure";
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
				if (con != null) {
					System.out.println("in finally update counter terrorism, for close!!");
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return response;
	}
}
