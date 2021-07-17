package com.board.home.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;


import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCtest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void TestConnection() {
		try(
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##scott","tiger")
		){
			log.info(con);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
