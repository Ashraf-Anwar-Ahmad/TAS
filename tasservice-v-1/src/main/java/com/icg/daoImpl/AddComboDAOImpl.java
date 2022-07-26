package com.icg.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icg.dao.AddComboDAO;
import com.icg.dto.DropdownMaster;
import com.icg.extention.HelperExtension;
import com.icg.utils.JdbcConnectionUtil;

import oracle.jdbc.OracleTypes;

public class AddComboDAOImpl implements AddComboDAO {

	ObjectMapper objectMapper;
	HelperExtension helperExtension = new HelperExtension();
	private int status = 0;
	private String response = null;

	public String getCombo(String id, String type) {

		// System.out.println(" type in daoimpl :: "+type);

		objectMapper = new ObjectMapper();

		Connection con = JdbcConnectionUtil.getConnection();
		ResultSet rset = null;
		CallableStatement callableStatement = null;
		List<DropdownMaster> searchDTOList = new ArrayList<DropdownMaster>();
		try {
			String viewInventoryStatus = "{call Pr_Get_Combo_Data(?,?,?,?)}";
			callableStatement = con.prepareCall(viewInventoryStatus);
			callableStatement.setString(1, id);
			callableStatement.setString(2, type);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.registerOutParameter(4, OracleTypes.VARCHAR);
			callableStatement.executeUpdate();

			rset = (ResultSet) callableStatement.getObject(3);
			while (rset.next()) {
				DropdownMaster getBean = new DropdownMaster();
				getBean.setId(rset.getString(1));
				getBean.setDesc(rset.getString(2));
				getBean.setName(rset.getString(3));
				searchDTOList.add(getBean);
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
			jsonResponse = objectMapper.writeValueAsString(searchDTOList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonResponse;

	}

	public String getComboMem(String id, String type) {
		objectMapper = new ObjectMapper();

		Connection con = JdbcConnectionUtil.getConnection();
		ResultSet rset = null;
		CallableStatement callableStatement = null;
		DropdownMaster getBean = new DropdownMaster();
		try {
			String viewInventoryStatus = "{call Pr_Get_Combo_Data(?,?,?,?)}";
			callableStatement = con.prepareCall(viewInventoryStatus);
			callableStatement.setString(1, id);
			callableStatement.setString(2, type);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.registerOutParameter(4, OracleTypes.VARCHAR);
			callableStatement.executeUpdate();

			rset = (ResultSet) callableStatement.getObject(3);
			while (rset.next()) {

				getBean.setId(rset.getString(1));
				getBean.setDesc(rset.getString(2));
				getBean.setName(rset.getString(3));
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
			jsonResponse = objectMapper.writeValueAsString(getBean);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonResponse;
	}

	public String checkInputId(String inpuId) {
		objectMapper = new ObjectMapper();

		Connection con = JdbcConnectionUtil.getConnection();
		CallableStatement callableStatement = null;
		try {
			String viewInventoryStatus = "{call Pr_Validate_Input_Id(?,?)}";
			callableStatement = con.prepareCall(viewInventoryStatus);
			callableStatement.setString(1, inpuId);
			callableStatement.registerOutParameter(2, OracleTypes.VARCHAR);
			status = callableStatement.executeUpdate();
			response = callableStatement.getString(2);

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
		return response;

	}

}
