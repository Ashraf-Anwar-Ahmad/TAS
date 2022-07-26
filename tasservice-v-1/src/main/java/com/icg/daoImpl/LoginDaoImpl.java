package com.icg.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icg.dao.LoginDao;
import com.icg.dto.Login;
import com.icg.dto.ResponseModel;
import com.icg.extention.ConstantExtension;
import com.icg.utils.ActiveDirectoryAuthentication;
import com.icg.utils.JdbcConnectionUtil;

import oracle.jdbc.OracleTypes;

public class LoginDaoImpl implements LoginDao {

	public String validateUser(String... varArg) {
		String loginStatus = "F";// T if user exists and F if user doesn't exist
		Connection con = JdbcConnectionUtil.getConnection();
		CallableStatement callableStatement = null;
		try {
			String sql = "{call Pr_validate_user(?,?,?)}";
			callableStatement = con.prepareCall(sql);
			callableStatement.setString(1, varArg[0]);
			callableStatement.setString(2, varArg[1]);
			callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
			callableStatement.executeUpdate();
			loginStatus = callableStatement.getString(3);
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
		
		return loginStatus;

	}

	public ResponseModel getLogin(String userName, String password) {

		JsonNode jsonNode = null;
		ObjectMapper objectMapper = new ObjectMapper();
		ResponseModel responseModel;

		Connection con = JdbcConnectionUtil.getConnection();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		CallableStatement callableStatement = null;
		Login dto = new Login();

		ActiveDirectoryAuthentication authentication = new ActiveDirectoryAuthentication("chakra.icg");
		List<Login> login = new ArrayList<Login>();
		try {
			System.out.println("User Name:: " + userName);
			System.out.println("Password:: " + password);
			// boolean authResult = authentication.authenticate(userName,password);
			boolean authResult = true;
			System.out.println("Auth: " + authResult);
			// boolean authResult =true;

			if (authResult) {

				try {

					String getLoginDetails = "{call PR_GET_OU(?,?,?)}";
					callableStatement = con.prepareCall(getLoginDetails);
					callableStatement.setString(1, userName);
					callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
					callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);

					callableStatement.executeUpdate();

					rset = (ResultSet) callableStatement.getObject(2);
					/*
					 * dto.setUserName("SDOT"); dto.setOrgUnitId("123"); dto.setOrgUnit("DIT");
					 * login.add(dto);
					 */
					while (rset.next()) {

						dto.setUserName(rset.getString(1));
						dto.setOrgUnitId(rset.getString(2));
						dto.setOrgUnit(rset.getString(3));
						dto.setpId(rset.getString(4));
						login.add(dto);

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (con != null) {
						try {
							con.close();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					jsonNode = objectMapper.valueToTree(login);
					responseModel = new ResponseModel(true, ConstantExtension.SUCCESS_RECEIVE, jsonNode);
				}
			} else {
				responseModel = new ResponseModel(false, ConstantExtension.LOGIN_MESSAGE_ERROR, jsonNode);
			}

		} catch (Exception e) {
			e.printStackTrace();
			responseModel = new ResponseModel(false, ConstantExtension.MESSAGE_ERROR, jsonNode);
		}

		return responseModel;

	}
}

/*
 * ObjectMapper objectMapper; HelperExtension helperExtension = new
 * HelperExtension(); public ResponseModel getLogin(String userName, String
 * password) {
 * 
 * ResponseModel responseModel = null; JsonNode jsonNode = null; objectMapper =
 * new ObjectMapper(); LoginDTO dto = new LoginDTO();
 * 
 * System.out.println(userName); System.out.println(password);
 * 
 * Connection con = JdbcConnectionUtil.getConnection(); //PreparedStatement stmt
 * = null; ResultSet rset = null; CallableStatement callableStatement = null;
 * User userModel = new User(); List<User> userList=new ArrayList<User>();
 * 
 * try { String getLoginDetails = "{call PR_GET_OU(?,?,?)}"; callableStatement =
 * con.prepareCall(getLoginDetails); callableStatement.setString(1, userName);
 * callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
 * callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
 * 
 * callableStatement.executeUpdate(); rset = (ResultSet)
 * callableStatement.getObject(2); while (rset.next()) {
 * 
 * userModel.setUserName(rset.getString(1));
 * userModel.setOrgUnitId(rset.getString(2));
 * userModel.setOrgUnit(rset.getString(3)); userList.add(userModel);
 * 
 * } jsonNode=objectMapper.valueToTree(userList);
 * 
 * System.out.println(jsonNode); responseModel = new ResponseModel(true,
 * callableStatement.getString(3), jsonNode);
 * 
 * } catch (Exception e) { // TODO Auto-generated catch block
 * e.printStackTrace(); }finally{ if(con!=null){ try { con.close(); } catch
 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
 * } }
 * 
 * return responseModel;
 * 
 * } }
 * 
 */