package com.icg.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icg.dao.SearchThreatDAO;
import com.icg.dto.Ammunition;
import com.icg.dto.AmmunitionStr;
import com.icg.dto.Boat;
import com.icg.dto.BoatStr;
import com.icg.dto.Contact;
import com.icg.dto.Crew;
import com.icg.dto.CrewStr;
import com.icg.dto.GetSearchDTO;
import com.icg.dto.Narcotic;
import com.icg.dto.PassengerBean;
import com.icg.dto.SearchThreatBean;
import com.icg.dto.ThreatHistoryBean;
import com.icg.dto.Vessel;
import com.icg.dto.VesselStr;
import com.icg.dto.ViewBean;
import com.icg.dto.ViewPDFBean;
import com.icg.extention.HelperExtension;
import com.icg.utils.JdbcConnectionUtil;

import oracle.jdbc.OracleTypes;

public class SearchThreatDAOImpl implements SearchThreatDAO {

	ObjectMapper objectMapper;
	HelperExtension helperExtension = new HelperExtension();

	public String getSearchThreatList(String... varArg) {
		HashMap<String, String> pr_inputParam = new HashMap<String, String>();
		pr_inputParam.put("0001", "");// IMEI No.
		pr_inputParam.put("0002", "");// Contact No.
		pr_inputParam.put("0003", "");// Position
		pr_inputParam.put("0004", "");// Region
		pr_inputParam.put("0005", "");// State
		pr_inputParam.put("0006", "");// Location
		pr_inputParam.put("0007", "");// From Date
		pr_inputParam.put("0008", "");// To Date
		pr_inputParam.put("0009", "");// Boat
		pr_inputParam.put("0010", "");// Vessel
		pr_inputParam.put("0011", "");// Crew Name
		if (pr_inputParam.containsKey(varArg[0])) {
			pr_inputParam.put(varArg[0], varArg[1]);
		}

		// System.out.println("getSearchThreatList-- "+varArg[0]+"--"+varArg[1]);
		objectMapper = new ObjectMapper();

		Connection con = JdbcConnectionUtil.getConnection();
		ResultSet rset = null;
		CallableStatement callableStatement = null;
		List<SearchThreatBean> searchThreatBeanList = new ArrayList<SearchThreatBean>();

		try {

			String sql = "{call Pr_Search_Threat_Data(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			callableStatement = con.prepareCall(sql);
			callableStatement.setString(1, pr_inputParam.get("0001"));// IMEI No.
			callableStatement.setString(2, pr_inputParam.get("0002"));// Contact No.
			callableStatement.setString(3, pr_inputParam.get("0003"));// Position
			callableStatement.setString(4, pr_inputParam.get("0004"));// Region
			callableStatement.setString(5, pr_inputParam.get("0005"));// State
			callableStatement.setString(6, pr_inputParam.get("0006"));// Location
			callableStatement.setString(7, pr_inputParam.get("0007"));// From Date
			callableStatement.setString(8, pr_inputParam.get("0008"));// To Date
			callableStatement.setString(9, pr_inputParam.get("0009"));// Boat
			callableStatement.setString(10, pr_inputParam.get("0010"));// Vessel
			callableStatement.setString(11, pr_inputParam.get("0011"));// Crew Name
			callableStatement.registerOutParameter(12, OracleTypes.CURSOR);
			callableStatement.registerOutParameter(13, OracleTypes.VARCHAR);
			callableStatement.executeUpdate();
			rset = (ResultSet) callableStatement.getObject(12);
			while (rset.next()) {
				SearchThreatBean searchThreatBean = new SearchThreatBean();
				searchThreatBean.setInputId(rset.getString(1));
				searchThreatBean.setDateOfReceipt(rset.getString(2));
				searchThreatBean.setOriginator(rset.getString(3));
				searchThreatBean.setLatitute(checkNullOrEmpty(rset.getString(4), ""));
				searchThreatBean.setLongitute(checkNullOrEmpty(rset.getString(5), ""));
				searchThreatBean.setTimeOfActivation(rset.getString(6));
				searchThreatBean.setImeiNo(rset.getString(7));
				searchThreatBean.setCountryOfContactedNo(rset.getString(8));
				searchThreatBean.setContactedTelephoneNumber(rset.getString(9));
				searchThreatBean.setDistanceFromLand(rset.getString(10));
				searchThreatBean.setGenDetlsId(rset.getString(11));
				searchThreatBean.setTypeOfThreatId(rset.getString(12));

				// searchThreatBean.setOperatingArea(rset.getString(10));
				// searchThreatBean.setOperatingArea("OperatingArea");

				searchThreatBeanList.add(searchThreatBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (callableStatement != null)
					callableStatement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String jsonResponse = null;
		try {

			jsonResponse = objectMapper.writeValueAsString(searchThreatBeanList);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonResponse;

	}

	public String getThreatHistoryList(String... varArg) {
		objectMapper = new ObjectMapper();
		Connection con = JdbcConnectionUtil.getConnection();
		ResultSet rset = null;
		CallableStatement callableStatement = null;
		List<ThreatHistoryBean> threatHistoryBeanList = new ArrayList<ThreatHistoryBean>();
		try {
			String sql = "{call PR_GET_THREAT_HISTORY(?,?)}";
			callableStatement = con.prepareCall(sql);
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			callableStatement.registerOutParameter(2, OracleTypes.VARCHAR);
			callableStatement.executeUpdate();
			rset = (ResultSet) callableStatement.getObject(1);
			while (rset.next()) {
				ThreatHistoryBean threatHistoryBeanObj = new ThreatHistoryBean();
				threatHistoryBeanObj.setGenDtlsId(rset.getString(1));
				threatHistoryBeanObj.setInputId(rset.getString(2));
				threatHistoryBeanObj.setOriginator(rset.getString(3));
				threatHistoryBeanObj.setLatitute(checkNullOrEmpty(rset.getString(4), ""));
				threatHistoryBeanObj.setLongitute(checkNullOrEmpty(rset.getString(5), ""));
				threatHistoryBeanObj.setTimeOfActivation(rset.getString(6));
				threatHistoryBeanObj.setImeiNo(rset.getString(7));
				threatHistoryBeanObj.setDistanceFromLand(rset.getString(8));
				threatHistoryBeanObj.setRegion(rset.getString(9));
				threatHistoryBeanObj.setTypeOfThreatId(rset.getString(10));
				threatHistoryBeanList.add(threatHistoryBeanObj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (callableStatement != null)
					callableStatement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String jsonResponse = null;
		try {

			jsonResponse = objectMapper.writeValueAsString(threatHistoryBeanList);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonResponse;

	}

	public String getViewList(String... varArg) {
		objectMapper = new ObjectMapper();
		Connection con = JdbcConnectionUtil.getConnection();
		ResultSet rset = null;
		CallableStatement callableStatement = null;

		// Map<String ,Object> return_output =new HashMap<>();

		List<ViewBean> viewBeanList = new ArrayList<ViewBean>();
		try {
			String sql = "{call PR_VIEW_THREAT(?,?)}";

			callableStatement = con.prepareCall(sql);
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			callableStatement.registerOutParameter(2, OracleTypes.VARCHAR);

			callableStatement.executeUpdate();
			rset = (ResultSet) callableStatement.getObject(1);
			// System.out.println("rset--"+rset.getFetchSize());
			while (rset.next()) {
				ViewBean viewBeanObj = new ViewBean();
				// System.out.println("--"+rset.getString(1));
				viewBeanObj.setGenDtlsId(rset.getString(1));
				viewBeanObj.setInputId(rset.getString(2));
				viewBeanObj.setDateOfReceipt(rset.getString(3));
				viewBeanObj.setOriginator(rset.getString(4));

				// System.out.println("rset.getString(5)--"+rset.getString(5));

				viewBeanObj.setLatitute(checkNullOrEmpty(rset.getString(5), ""));
				viewBeanObj.setLongitute(checkNullOrEmpty(rset.getString(6), ""));

				viewBeanObj.setTypeOfThreat(rset.getString(7));
				viewBeanObj.setTypeOfThreatId(rset.getString(8));
				viewBeanList.add(viewBeanObj);
			}

			// System.out.println("viewBeanList--"+viewBeanList.size());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (callableStatement != null)
					callableStatement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String jsonResponse = null;
		try {

			jsonResponse = objectMapper.writeValueAsString(viewBeanList);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonResponse;

	}

	public ViewPDFBean getViewPdfList(String... varArg) {

		ViewPDFBean threat = new ViewPDFBean();
		Connection con = JdbcConnectionUtil.getConnection();
		ResultSet rset = null;
		CallableStatement callableStatement = null;
		try {

			String procedure = "{call PR_GET_THREAT_DATA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			callableStatement = con.prepareCall(procedure);

			callableStatement.setString(1, varArg[0]);

			callableStatement.registerOutParameter(2, OracleTypes.CURSOR); // General details cursor
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR); // Contact Details cursor
			callableStatement.registerOutParameter(4, OracleTypes.CURSOR); // Threat type(smuggling) details cursor
			callableStatement.registerOutParameter(5, OracleTypes.CURSOR); // Boat details cursor
			callableStatement.registerOutParameter(6, OracleTypes.CURSOR); // Vessel details cursor
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR); // Crew details cursor
			callableStatement.registerOutParameter(8, OracleTypes.CURSOR); // Passenger details cursor
			callableStatement.registerOutParameter(9, OracleTypes.CURSOR); // Ammunition details cursor
			callableStatement.registerOutParameter(10, OracleTypes.CURSOR); // Other info cursor
			callableStatement.registerOutParameter(11, OracleTypes.CURSOR); // Units involved cursor
			callableStatement.registerOutParameter(12, OracleTypes.CURSOR); // Narcotics details cursor
			callableStatement.registerOutParameter(13, OracleTypes.CURSOR);	// IMEI detail cursor
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
				// threat.setLocation(rset.getString(18));
				threat.setLocation(rset.getString(30));
				threat.setRegionId(rset.getString(19));
				threat.setRegionName(rset.getString(20));
				threat.setCoastStatId(rset.getString(21));
				threat.setCoastStatName(rset.getString(22));
				threat.setImeiNo(rset.getString(23));
				threat.setNameSuspects(rset.getString(24));
				threat.setSharedWithId(rset.getString(25));
				threat.setSharedWithName(rset.getString(26));
				threat.setOtherInfo(rset.getString(27));
				threat.setFollowUp(rset.getString(28));
				threat.setFromWhere(rset.getString(29));

			}

			rset = null;
			rset = (ResultSet) callableStatement.getObject(3);
			List<Contact> contactList = getContactList(rset);
			threat.setContactList(contactList);

			rset = null;
			rset = (ResultSet) callableStatement.getObject(4);
			while (rset.next()) {
				threat.setSmugId(rset.getString(1));
				threat.setUnit(rset.getString(2));
				threat.setUnitDescr(rset.getString(3));
				threat.setTypeOfContra(rset.getString(4));
				threat.setQuantity(rset.getString(5));
				threat.setWeight(rset.getString(6));
				threat.setWorth(rset.getString(7));
				threat.setCaseHandedTo(rset.getString(8));
				threat.setLocBoughtTo(rset.getString(9));
				threat.setJointOperWith(rset.getString(10));
				threat.setNarcoticType(rset.getString(11));
				threat.setNarcoticTypeDescr(rset.getString(12));
				threat.setNoOfPass(rset.getString(13));
				threat.setInvesAgency(rset.getString(14));
				threat.setApplattitudeDec(rset.getString(15));
				threat.setApplongitudeDec(rset.getString(16));
				threat.setApplattitudeDeg(rset.getString(17));
				threat.setApplongitudeDeg(rset.getString(18));
				threat.setApprehensionDt(rset.getString(19));

			}

			rset = null;
			rset = (ResultSet) callableStatement.getObject(5);
			BoatStr btst = getBoatList(rset);
			threat.setBoatList(btst.getBoatList());
			threat.setBoatStrList(btst.getBoatStrList());

			rset = null;
			rset = (ResultSet) callableStatement.getObject(6);
			VesselStr vslst = getVesselList(rset);
			threat.setVesselList(vslst.getVesselList());
			threat.setVesselStrList(vslst.getVesselStrList());

			rset = null;
			rset = (ResultSet) callableStatement.getObject(7);
			CrewStr crwlst = getCrewList(rset);
			threat.setCrewList(crwlst.getCrewList());
			threat.setCrewStrList(crwlst.getCrewStrList());

			rset = null;
			rset = (ResultSet) callableStatement.getObject(8);
			List<PassengerBean> passengerList = getPassengerList(rset);
			threat.setPassengerList(passengerList);

			rset = null;
			rset = (ResultSet) callableStatement.getObject(9);
			AmmunitionStr amnst = getAmmunitionList(rset);
			threat.setAmmunitionList(amnst.getAmmunitionList());

			rset = null;
			rset = (ResultSet) callableStatement.getObject(10);
			while (rset.next()) {

			}

			rset = null;
			rset = (ResultSet) callableStatement.getObject(11);
			ArrayList<String> untLst = new ArrayList<String>();
			while (rset.next()) {
				String str = rset.getString(2);
				if (str != null && !str.isEmpty()) {
					untLst.add(str);
				}
			}
			// System.out.println("untLst--"+untLst.size());
			threat.setIcgUnitsName(untLst);
			rset = null;
			rset = (ResultSet) callableStatement.getObject(12);
			List<Narcotic> narcoticList = getNarcoticList(rset);
			threat.setNarcoticList(narcoticList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
				}
				if (con != null) {
					// System.out.println("in finally view details, for close!!");
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return threat;
	}

	// Extra Method

	public List<Contact> getContactList(ResultSet rset) throws SQLException {
		List<Contact> list = new ArrayList<Contact>();
		while (rset.next()) {
			Contact contact = new Contact();
			contact.setCntctId(rset.getString(1));
			contact.setContactNo(rset.getString(2));
			contact.setCountry(rset.getString(3));
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
			boat.setRegNum(rset.getString(3));
			boat.setOwnerName(rset.getString(4));
			boat.setPortReg(rset.getString(5));
			boat.setNoOfCrew(rset.getString(6));
			boat.setDocHeld(rset.getString(7));
			boat.setNavEqpt(rset.getString(8));
			boat.setCommEqpt(rset.getString(9));
			boat.setLifeEqpt(rset.getString(10));
			boat.setBoatlpc(rset.getString(11));
			boat.setBoatetd(rset.getString(12));
			boat.setBoatnpc(rset.getString(13));
			boat.setBoateta(rset.getString(14));
			boat.setLicenseFish(rset.getString(15));
			boat.setOwnerContDts(rset.getString(16));
			boat.setBoatColrcd(rset.getString(17));
			boat.setRemarks(rset.getString(18));
			boatStr.add(rset.getString(1));
			list.add(boat);
		}
		BoatStr bt = new BoatStr();
		bt.setBoatList(list);
		bt.setBoatStrList(botStrList);
		return bt;
	}

	public VesselStr getVesselList(ResultSet rset) throws SQLException {
		List<Vessel> list = new ArrayList<Vessel>();
		while (rset.next()) {
			Vessel vessel = new Vessel();
			vessel.setVesselId(rset.getString(1));
			vessel.setVesselName(rset.getString(2));
			vessel.setVesselTypeId(rset.getString(3));
			vessel.setVesselTypeName(rset.getString(4));
			vessel.setIntCallSign(rset.getString(5));
			vessel.setMmsi(rset.getString(6));
			vessel.setImoNo(rset.getString(7));
			vessel.setCargo(rset.getString(8));
			vessel.setVessellpc(rset.getString(9));
			vessel.setVesseletd(rset.getString(10));
			vessel.setVesselnpc(rset.getString(11));
			vessel.setVesseleta(rset.getString(12));
			vessel.setTotCrew(rset.getString(13));
			vessel.setFlgPrtReg(rset.getString(14));
			vessel.setInmarsatNo(rset.getString(15));
			vessel.setOtherCommEqpt(rset.getString(16));
			vessel.setAgent(rset.getString(17));
			vessel.setPans(rset.getString(18));
			list.add(vessel);
		}
		VesselStr bt1 = new VesselStr();
		bt1.setVesselList(list);

		return bt1;
	}

	public CrewStr getCrewList(ResultSet rset) throws SQLException {
		List<Crew> list = new ArrayList<Crew>();

		while (rset.next()) {
			Crew crew = new Crew();
			crew.setCrId(rset.getString(1));
			crew.setCrName(rset.getString(2));
			crew.setCrAge(rset.getString(3));
			crew.setCrNationality(rset.getString(4));
			crew.setCrAddress(rset.getString(5));
			crew.setCrTelNo(rset.getString(6));
			crew.setCrMartStsId(rset.getString(7));
			crew.setCrMartSts(rset.getString(8));
			crew.setCrProfession(rset.getString(9));
			crew.setCrIdenMrks(rset.getString(10));
			crew.setCrRelgnId(rset.getString(11));
			crew.setCrRelgn(rset.getString(12));
			crew.setCrDtlsIdPf(rset.getString(13));
			list.add(crew);
		}
		CrewStr bt1 = new CrewStr();
		bt1.setCrewList(list);

		return bt1;
	}

	public AmmunitionStr getAmmunitionList(ResultSet rset) throws SQLException {
		List<Ammunition> list = new ArrayList<Ammunition>();
		while (rset.next()) {
			Ammunition ammunition = new Ammunition();
			ammunition.setAmmunId(rset.getString(1));
			ammunition.setTypeAmmun(rset.getString(2));
			ammunition.setAmmunQty(rset.getString(3));
			ammunition.setAmmunMake(rset.getString(4));
			ammunition.setAmmunModel(rset.getString(5));
			ammunition.setAmmunManuCntry(rset.getString(6));
			ammunition.setAmmunRmks(rset.getString(7));
			list.add(ammunition);
		}
		AmmunitionStr bt1 = new AmmunitionStr();
		bt1.setAmmunitionList(list);

		return bt1;
	}

	public List<PassengerBean> getPassengerList(ResultSet rset) throws SQLException {
		List<PassengerBean> list = new ArrayList<PassengerBean>();
		while (rset.next()) {
			PassengerBean passenger = new PassengerBean();
			passenger.setName(rset.getString(2));
			passenger.setAge(rset.getString(3));
			passenger.setGenderDescr(rset.getString(5));
			passenger.setNationality(rset.getString(6));
			passenger.setAddress(rset.getString(7));
			passenger.setTelephoneNumber(rset.getString(8));
			passenger.setMaritalStatusDescr(rset.getString(10));
			passenger.setProfession(rset.getString(11));
			passenger.setIdentificationMarks(rset.getString(12));
			passenger.setReligionDescr(rset.getString(14));
			list.add(passenger);
		}
		return list;
	}

	String checkNullOrEmpty(String value, String replaceStr) {

		return ((value == null || value.isEmpty()) ? replaceStr : value);
	}

	@Override
	public String getSearchThreatList(GetSearchDTO getSearchDTO) {

		// System.out.println("getSearchThreatList-- "+varArg[0]+"--"+varArg[1]);
		objectMapper = new ObjectMapper();
		Connection con = JdbcConnectionUtil.getConnection();
		CallableStatement callableStatement = null;

		ResultSet rset = null;

		List<SearchThreatBean> searchThreatBeanList = new ArrayList<SearchThreatBean>();

		try {

			String sql = "{call Pr_Search_Threat_Data(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			callableStatement = con.prepareCall(sql);

			callableStatement.setString(1, getSearchDTO.getImeiNo());// IMEI No.
			callableStatement.setString(2, getSearchDTO.getContactNo());// Contact No.
			callableStatement.setString(3, getSearchDTO.getLongitude());// Longitude
			callableStatement.setString(4, getSearchDTO.getLatitude()); // Latitude
			callableStatement.setString(5, getSearchDTO.getRegion());// Region
			callableStatement.setString(6, getSearchDTO.getState());// State
			callableStatement.setString(7, getSearchDTO.getLocation());// Location
			callableStatement.setString(8, getSearchDTO.getFromDate());// From Date
			callableStatement.setString(9, getSearchDTO.getToDate());// To Date
			callableStatement.setString(10, getSearchDTO.getBoatName());// Boat Name
			callableStatement.setString(11, getSearchDTO.getVesselName());// Vessel Name
			callableStatement.setString(12, getSearchDTO.getCrewName());// Crew Name
			callableStatement.setString(13, getSearchDTO.getInputId());// Input-Id
			callableStatement.setString(14, getSearchDTO.getThreatType());// Threat-Type
			callableStatement.setString(15, getSearchDTO.getNarcoticType());// Narcotic-Type
			callableStatement.setString(16, getSearchDTO.getContrabandType());// Contraband-Type
			callableStatement.setString(17, getSearchDTO.getBoatRegNo());// Boat Reg No
			callableStatement.setString(18, getSearchDTO.getBoatPortOfReg());// Boat Port of Reg
			callableStatement.setString(19, getSearchDTO.getBoatLPC()); // Boat LPC
			callableStatement.setString(20, getSearchDTO.getBoatNPC()); // Boat NPC
			callableStatement.setString(21, getSearchDTO.getOriginator()); // Originator
			callableStatement.setString(22, getSearchDTO.getGrading()); // Grading
			callableStatement.setString(23, getSearchDTO.getVesselFlagAndPortOfReg()); // Vessel flag and port of
																						// Registration
			callableStatement.registerOutParameter(24, OracleTypes.CURSOR);
			callableStatement.registerOutParameter(25, OracleTypes.VARCHAR);
			callableStatement.executeUpdate();
			rset = (ResultSet) callableStatement.getObject(24);
			while (rset.next()) {
				SearchThreatBean searchThreatBean = new SearchThreatBean();
				searchThreatBean.setInputId(rset.getString(1));
				searchThreatBean.setDateOfReceipt(rset.getString(2));
				searchThreatBean.setOriginator(rset.getString(3));
				searchThreatBean.setLatitute(checkNullOrEmpty(rset.getString(4), ""));
				searchThreatBean.setLongitute(checkNullOrEmpty(rset.getString(5), ""));
				searchThreatBean.setTimeOfActivation(rset.getString(6));
				searchThreatBean.setImeiNo(rset.getString(7));
				searchThreatBean.setCountryOfContactedNo(rset.getString(8));
				searchThreatBean.setContactedTelephoneNumber(rset.getString(9));
				searchThreatBean.setDistanceFromLand(rset.getString(10));
				searchThreatBean.setGenDetlsId(rset.getString(11));
				searchThreatBean.setTypeOfThreatId(rset.getString(12));

				// searchThreatBean.setOperatingArea(rset.getString(10));
				// searchThreatBean.setOperatingArea("OperatingArea");

				searchThreatBeanList.add(searchThreatBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (callableStatement != null)
					callableStatement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String jsonResponse = null;
		try {

			jsonResponse = objectMapper.writeValueAsString(searchThreatBeanList);

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonResponse;

	}

	// ................./mapper method.....................
}
