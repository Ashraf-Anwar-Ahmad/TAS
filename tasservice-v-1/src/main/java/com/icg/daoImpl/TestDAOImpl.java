package com.icg.daoImpl;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icg.dao.TestDAO;
import com.icg.dto.Contact;
import com.icg.dto.Test;
import com.icg.utils.JdbcConnectionUtil;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleTypes;

public class TestDAOImpl implements TestDAO {

	ObjectMapper objectMapper;
	private int status=0;
	private String response=null;
	public String add(Test testcl) {
		objectMapper = new ObjectMapper();
		Connection con = JdbcConnectionUtil.getConnection();
		CallableStatement callableStatement = null;
		try {
			
			String groupAdd = "{call Pr_Set_Cont_Dtls(?,?,?)}";
			callableStatement = con.prepareCall(groupAdd);
			List<Contact> contact=testcl.getContctList();
		      int i=0;
		      Struct[] structArrayOfProjects1=new Struct[contact.size()];
		      for(Contact cnt: contact) {
		    	  Object[] check1 = new Object[] {cnt.getContactNo(), cnt.getCountry()};
		    	  Struct structPrt1 = con.createStruct("CON_DET", check1);
		    	  structArrayOfProjects1[i]=structPrt1;
		    	  i++;
				}
		      Array arrayOfProjects = ((OracleConnection) con).createOracleArray("CONT_DTLS", structArrayOfProjects1);

		      callableStatement.setArray(1, arrayOfProjects); 
			callableStatement.setString(2, "0");
			
			callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
			status=callableStatement.executeUpdate();
//			System.out.println("status="+status);
//			System.out.println("status=="+callableStatement.getString(3));
		
			response=callableStatement.getString(3);
			
		}
			catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(callableStatement != null)
					callableStatement.close();
				if(con != null)
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return response;
	}
}
