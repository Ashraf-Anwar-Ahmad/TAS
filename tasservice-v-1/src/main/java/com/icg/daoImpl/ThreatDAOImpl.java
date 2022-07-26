package com.icg.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icg.dao.ThreatDAO;
import com.icg.dto.ThreatCheck;
import com.icg.dto.ThreatReceive;
import com.icg.utils.JdbcConnectionUtil;

import oracle.jdbc.OracleTypes;

public class ThreatDAOImpl implements ThreatDAO {


	ObjectMapper objectMapper;
	public String getList(ThreatCheck threat) {
		objectMapper = new ObjectMapper();
		List<ThreatReceive> recList=new ArrayList<ThreatReceive>();
    	Connection con = JdbcConnectionUtil.getConnection();
		ResultSet rset = null;
		CallableStatement callableStatement = null;
		try {

			String procedure = "{call PR_GET_DUPLICATE_ALERT(?,?,?,?,?,?,?,?,?)}";
			callableStatement = con.prepareCall(procedure);
			String contCommaSeparated=null, boatCommaSeparated=null;
			String vesselCommaSeparated=null;
			callableStatement.setString(1, threat.getThrtimeiNo());
			if(threat.getContactList()!=null && threat.getContactList().size()>0) {
				contCommaSeparated = threat.getContactList().stream().map(contact -> contact.getContactNo())
		                .collect(Collectors.joining(","));
			}
			
			callableStatement.setString(2, contCommaSeparated);
			callableStatement.setString(3, threat.getThrtgpsLong());
			callableStatement.setString(4, threat.getThrtgpsLat());
			callableStatement.setString(5, threat.getThrtSusNam());
			
			if(threat.getBoatList()!=null && threat.getBoatList().size()>0) {
				boatCommaSeparated = threat.getBoatList().stream().map(boat -> boat.getBoatName())
		                .collect(Collectors.joining(","));
			}
			if(threat.getVesselList()!=null && threat.getVesselList().size()>0) {
				vesselCommaSeparated = threat.getVesselList().stream().map(vessel -> vessel.getVesselName())
		                .collect(Collectors.joining(","));
			}
			
			callableStatement.setString(6, boatCommaSeparated);
			callableStatement.setString(7, vesselCommaSeparated);
			
			callableStatement.registerOutParameter(8, OracleTypes.CURSOR); 
			
			callableStatement.registerOutParameter(9, OracleTypes.VARCHAR);
			
			callableStatement.executeUpdate();

			rset = (ResultSet) callableStatement.getObject(8);
			while (rset.next()) {
				ThreatReceive recv=new ThreatReceive();
				recv.setRecInptId(rset.getString(1));
				recv.setRecThrtTyp(rset.getString(2));
				recv.setRecOrgntr(rset.getString(3));
				recv.setRecgpsLat(rset.getString(4));
				recv.setRecgpsLong(rset.getString(5));
				recv.setRecimeiNo(rset.getString(6));
				recv.setRecCntry(rset.getString(7));
				recv.setRecDstncKm(rset.getString(8));
				recv.setRecLoc(rset.getString(9));
				recv.setRecReg(rset.getString(10));
				recv.setRecSuspctNm(rset.getString(11));
				recList.add(recv);
			}
			
			
     }catch(Exception e) {
			e.printStackTrace();
		}
		
		finally{
			try {
				if(callableStatement != null) {
					callableStatement.close();
				}
				if(con != null) {
				///	System.out.println("in finally threat alert check, for close!!");
					con.close();
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	
		//System.out.println("recvlist=="+recList.toString());
		String jsonResponse = null ;
		try {
		jsonResponse = objectMapper.writeValueAsString(recList);
		} catch (JsonProcessingException e) {
		e.printStackTrace();
		}
		return jsonResponse;
	}

}
