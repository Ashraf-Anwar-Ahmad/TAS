package com.icg.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionUtil {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//development database
			//con = DriverManager.getConnection("jdbc:oracle:thin:@172.18.0.30:1521/cgtestdb","tas", "tas123");
			
			//localhost
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/icgtasdb","tas", "tas123");
			
			//chakra
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.0.8.5:1521/taspdb","tas", "tas123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

}