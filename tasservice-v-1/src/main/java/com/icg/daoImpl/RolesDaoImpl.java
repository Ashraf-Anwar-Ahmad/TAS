package com.icg.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icg.dao.RolesDao;
import com.icg.dto.ResponseModel;
import com.icg.dto.Role;
import com.icg.utils.JdbcConnectionUtil;

import oracle.jdbc.OracleTypes;
public class RolesDaoImpl implements RolesDao {
	ObjectMapper objectMapper = new ObjectMapper();
	
	
	public ResponseModel getRoles(String userId) {
		
		ResponseModel responseModel = null;
		JsonNode jsonNode = null;
		objectMapper = new ObjectMapper();
		System.out.println("userId=="+userId);
		List<Role> roleList = new ArrayList<Role>();
		Connection con = JdbcConnectionUtil.getConnection();
		ResultSet rset = null;
		CallableStatement callableStatement = null;
		
		try {
			
			String getRoles = "{call PR_GET_ROLES(?,?,?)}";
			callableStatement = con.prepareCall(getRoles);
			callableStatement.setString(1, userId);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
			callableStatement.executeUpdate();
			rset = (ResultSet) callableStatement.getObject(2);
			while (rset.next()) {
				System.out.println("inside while");
			Role role=new Role();
			role.setRoleId(rset.getString(1));
			role.setRole(rset.getString(2));
			roleList.add(role);
			
		}

			jsonNode=objectMapper.valueToTree(roleList);
			
			System.out.println(jsonNode);
			responseModel = new ResponseModel(true, callableStatement.getString(3), jsonNode);
		}catch(Exception e) {
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
		
		return responseModel;
	}
	
}

	