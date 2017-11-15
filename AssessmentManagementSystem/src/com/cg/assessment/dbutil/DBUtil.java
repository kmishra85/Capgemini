package com.cg.assessment.dbutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	
	/*
	*********************************************************************
	* Module Name         	: getConnection()
	* Input Parameters     	: void
	* Return Type         	: Connection
	* Author              	: Keshav Mishra
	* Creation Date      	: 11-Oct-2017
	* Description        	: To get connection with the database
	 *********************************************************************
	*/	
	
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
