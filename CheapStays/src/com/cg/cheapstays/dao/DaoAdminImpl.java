package com.cg.cheapstays.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.cheapstays.bean.AdminDetails;
import com.cg.cheapstays.bean.HotelDetails;
import com.cg.cheapstays.dbutil.DBUtil;
import com.cg.cheapstays.exception.HotelException;



public class DaoAdminImpl implements IDaoAdmin{

	int result=0;
	Connection con=null;
	@Override
	public ArrayList<AdminDetails> adminAuthentication() {
		PropertyConfigurator.configure("log4j.properties");
		Logger logger = Logger.getRootLogger();
		ArrayList<AdminDetails> adminList=new ArrayList<AdminDetails>();
		try {
			con=DBUtil.getConnection();
			String sql="select username_admin,password_admin from admin_details";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				String user=rs.getString(1);
				String pass=rs.getString(2);
				adminList.add(new AdminDetails(user,pass));
			}
			logger.info("Values added in admin_details table");
			
		}
		catch (IOException e)
		{
			//e.printStackTrace();
			logger.error("Exception Occured"+e.getMessage());
		} 
		catch (SQLException e) 
		{
			logger.error("Exception Occured"+e.getMessage());
			//e.printStackTrace();
		}
	
	
		return adminList;
	}
	
	
	@Override
	public int addNewHotels(HotelDetails hDetails) throws HotelException {
		int res=0;
		PropertyConfigurator.configure("log4j.properties");
		Logger logger = Logger.getRootLogger();
		try
		{
			Connection conn=DBUtil.getConnection();
			String insertQuery= "INSERT INTO hotel_details VALUES(hotel_id_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(insertQuery);
			ps.setString(1,hDetails.getCity());
			//System.out.println(hDetails.getCity());
			ps.setString(2,hDetails.getHotelName());
			ps.setString(3,hDetails.getAddress());
			ps.setString(4, hDetails.getDescription());
			ps.setFloat(5, hDetails.getAvgRatePerNight());
			ps.setString(6, hDetails.getPhoneNo1());
			ps.setString(7, hDetails.getPhoneNo2());
			ps.setString(8, hDetails.getRating());
			ps.setString(9, hDetails.getEmail());
			ps.setString(10, hDetails.getFax());
						
			 res=ps.executeUpdate();
			// System.out.println("res value"+res);
			 logger.info("Values added in hotel_details table");
		} 
		catch (IOException e)
		{
			logger.error("Exception Occured"+e.getMessage());
			//throw new HotelException("IQ exception occured!");
		}
		catch (SQLException e)
		{
			logger.error("Exception Occured"+e.getMessage());
			//throw new HotelException("SQL exception occured!");
		}
		
		return res;
	}


	@Override
	public ArrayList<HotelDetails> retrieveDetails() throws HotelException {

		PropertyConfigurator.configure("log4j.properties");
		Logger logger = Logger.getRootLogger();
		ArrayList<HotelDetails> list =new ArrayList<HotelDetails>();
		try
		{
			Connection con = DBUtil.getConnection();
			String str="SELECT hotel_id,hotel_name FROM hotel_details";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(str);
		
			while(rs.next())
			{
				String hotelId=rs.getString(1);
				String hotelName=rs.getString(2);
			
				list.add(new HotelDetails(hotelId,hotelName));
			}
			logger.info("Values fetched from hotel_details table");
		} 
		catch (IOException e) 
		{
			
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("IQ exception occured!");

		} 
		catch (SQLException e)
		{
			
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("SQL exception occured!");

		}
		
			
		return list;
		
	}


	@Override
	public int deleteById(String deleteId) throws HotelException {
		int res=0;
		PropertyConfigurator.configure("log4j.properties");
		Logger logger = Logger.getRootLogger();
		try
		{
			Connection conn=DBUtil.getConnection();
			String insertQuery= "DELETE FROM hotel_details WHERE hotel_id=?";
			PreparedStatement ps=conn.prepareStatement(insertQuery);
			ps.setString(1,deleteId);
			
						
			 res=ps.executeUpdate();
			// System.out.println("res value"+res);
			 logger.info("Values deleted from hotel_details table");
		} 
		
		catch (IOException e)
		{
			
			//e.printStackTrace();
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("IQ exception occured!");

		}
		catch (SQLException e)
		{
			
			//e.printStackTrace();
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("SQL exception occured!");

		}
		
		return res;
	}


	@Override
	public int updateById(HotelDetails hd) throws HotelException 
	{
		int res=0;
		PropertyConfigurator.configure("log4j.properties");
		Logger logger = Logger.getRootLogger();
		try
		{
			Connection conn=DBUtil.getConnection();
			String insertQuery= "Update hotel_details set city=?,hotel_name=?,address=?,description=?,average_rate_per_night=?,phone_number_1=?,phone_number_2=?,rating=?,email=?,fax=? where hotel_id=?";
			PreparedStatement ps=conn.prepareStatement(insertQuery);
			ps.setString(1,hd.getCity());
			//System.out.println(hDetails.getCity());
			ps.setString(2,hd.getHotelName());
			ps.setString(3,hd.getAddress());
			ps.setString(4, hd.getDescription());
			ps.setFloat(5, hd.getAvgRatePerNight());
			ps.setString(6, hd.getPhoneNo1());
			ps.setString(7, hd.getPhoneNo2());
			ps.setString(8, hd.getRating());
			ps.setString(9, hd.getEmail());
			ps.setString(10, hd.getFax());
			ps.setString(11,hd.getHotelId());
						
			 res=ps.executeUpdate();
			// System.out.println("res value"+res);
			 logger.info("Values updated in hotel_details table");
		} 
		catch (IOException e)
		{
			logger.error("Exception Occured"+e.getMessage());
			//throw new HotelException("IQ exception occured!");

			//e.printStackTrace();
		}
		catch (SQLException e)
		{
			logger.error("Exception Occured"+e.getMessage());
			//throw new HotelException("SQL exception occured!");

			//e.printStackTrace();
		}
		
		return res;
	}


	@Override
	public HotelDetails retrieveById(String updateId) throws HotelException {
		PropertyConfigurator.configure("log4j.properties");
		Logger logger = Logger.getRootLogger();
		HotelDetails hd=new HotelDetails();
		
		try {
			con=DBUtil.getConnection();
			
			String q="select * from  hotel_details where hotel_id=?";
			PreparedStatement ps=con.prepareStatement(q);
			ps.setString(1, updateId);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String hotelId=rs.getString(1);
				String city1=rs.getString(2);
				String hotelName=rs.getString(3);
				String hotelAddress=rs.getString(4);
				String description=rs.getString(5);
				float avgRatePerNight=rs.getFloat(6);
				String phoneNo1=rs.getString(7);
				String phoneNo2=rs.getString(8);
				String rating=rs.getString(9);
				String email=rs.getString(10);
				String fax=rs.getString(11);
				
				
				hd.setCity(city1);
				hd.setAddress(hotelAddress);
				hd.setAvgRatePerNight(avgRatePerNight);
				hd.setDescription(description);
				hd.setEmail(email);
				hd.setFax(fax);
				hd.setHotelName(hotelName);
				hd.setPhoneNo1(phoneNo1);
				hd.setPhoneNo2(phoneNo2);
				hd.setRating(rating);
				hd.setHotelId(hotelId);
				logger.info("Values fetched from hotel_details table");	
			}
			
			
		} catch (IOException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("IQ exception occured!");

		} catch (SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("SQL exception occured!");

			
		}
		
		return hd;
	}


	@Override
	public ArrayList<String> validateUserName() throws HotelException {
		PropertyConfigurator.configure("log4j.properties");
		Logger logger = Logger.getRootLogger();
		ArrayList<String> li=new ArrayList<String>();
		try {
			con=DBUtil.getConnection();
			String sql="select username_admin from admin_details";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String user=rs.getString(1);
				li.add(user);
			}				
			logger.info("Values fetched from admin_details table");
	} catch (IOException e) {
		logger.error("Exception Occured"+e.getMessage());
	//	throw new HotelException("IQ exception occured!");
	} catch (SQLException e) {
		logger.error("Exception Occured"+e.getMessage());
	//	throw new HotelException("SQL exception occured!");
	}
		return li;
	}


	@Override
	public ArrayList<String> validatePassword() throws HotelException {
		PropertyConfigurator.configure("log4j.properties");
		Logger logger = Logger.getRootLogger();
		ArrayList<String> li=new ArrayList<String>();
		try {
			con=DBUtil.getConnection();
			String sql="select password_admin from admin_details";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String pass=rs.getString(1);
				li.add(pass);
			}
			logger.info("Values fetched from admin_details table");
		
	} catch (IOException e) {
		logger.error("Exception Occured"+e.getMessage());
	//	throw new HotelException("SQL exception occured!");
	} catch (SQLException e) {
		logger.error("Exception Occured"+e.getMessage());
	//	throw new HotelException("SQL exception occured!");
	}
		return li;
	}
	
	
	
	
	

	
}
