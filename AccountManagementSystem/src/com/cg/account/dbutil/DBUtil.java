package com.cg.account.dbutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	static Connection con=null;
	public static Connection getConnection() throws IOException
	{
		
		try {
		InitialContext ic=new InitialContext();
		DataSource ds=(DataSource) ic.lookup("java:/jdbc/OracleDS");
		con=ds.getConnection();
		
		
		} catch (NamingException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		System.out.println(con);
		return con;
	
}
}
