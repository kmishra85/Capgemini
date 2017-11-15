package com.cg.cheapstays.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.cheapstays.bean.BookingDetails;
import com.cg.cheapstays.bean.HotelDetails;
import com.cg.cheapstays.bean.RoomDetails;
import com.cg.cheapstays.bean.UserDetails;
import com.cg.cheapstays.dbutil.DBUtil;
import com.cg.cheapstays.exception.HotelException;

public class DaoCustomerImpl implements IDaoCustomer{
	Logger logger = Logger.getRootLogger();
Connection con=null;
int result=0;
static UserDetails ud=new UserDetails();
RoomDetails rd=new RoomDetails();
public RoomDetails addBooking(BookingDetails bd,UserDetails ud,String hotelId1,String roomType,long dayBetween) throws HotelException 
	{
	PropertyConfigurator.configure("log4j.properties");


	int roomId=0;
	float amount=0;
	String roomNo=null;
	try {
		String user=null;
		con=DBUtil.getConnection();
		String q="select user_id from user_details where mobile_no=?";
		PreparedStatement ps1=con.prepareStatement(q);

		ps1.setString(1,ud.getMobileNo());
		ResultSet rs=ps1.executeQuery();
		while(rs.next())
		{
			 user=rs.getString(1);
		}
		
		System.out.println("Hotel ID:"+hotelId1);
		
		String getSeqRoomId = "SELECT room_id,per_night_rate,room_no FROM room_details where hotel_id =? and room_type=? and availability='Y'";
		PreparedStatement ps2=con.prepareStatement(getSeqRoomId);

		ps2.setString(1,hotelId1);
		ps2.setString(2,roomType);
		ResultSet r = ps2.executeQuery();
		while(r.next())
		{
			roomId = r.getInt(1);
			amount=r.getFloat(2);
			roomNo=r.getString(3);
		}
		String roomId1=String.valueOf(roomId);
		rd.setRoomId(roomId1);
		rd.setPer_night_rate(amount);
		System.out.println("\nRoom ID:"+roomId);
		System.out.println("\nDays between:"+dayBetween);
		System.out.println("\nRoom No:"+roomNo+"\n");
		amount*=dayBetween;
		
		
		System.out.println("Your User ID : "+user);
		String query="insert into booking_details values(book_seq.nextval,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
	
		ps.setInt(1, roomId);
		ps.setDate(2,bd.getBookedFrom());
		ps.setDate(3, bd.getBookedTo());
		ps.setInt(4, bd.getNoOfAdults());
		ps.setInt(5, bd.getNoOfChildren());
		ps.setFloat(6, amount);
		ps.setString(7, user);
		
		result=ps.executeUpdate();
		
		logger.info("Executed Successfully");
		
	} catch (SQLException e) {
		logger.error("Exception Occured"+e.getMessage());
		throw new HotelException("SQL exception occured!");
	} catch (IOException e) {
		logger.error("Exception Occured"+e.getMessage());
		throw new HotelException("IO exception occured!");
	}
	
	
	
	
	return rd;	
	}

	@Override
	public int addRegister(UserDetails ud) throws HotelException {
		PropertyConfigurator.configure("log4j.properties");

		try {
			int seq=0;
			con=DBUtil.getConnection();
			
			String q="select user_seq.nextval from dual";
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery(q);
			while(rs.next())
			{
				seq=rs.getInt(1);
			}
			String query="insert into user_details values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
		
			
			ps.setInt(1,seq);
			ps.setString(2,ud.getPassword());
			ps.setString(3, ud.getRole());
			ps.setString(4, ud.getUserName());
			ps.setString(5, ud.getMobileNo());
			ps.setString(6, ud.getPhone());
			ps.setString(7, ud.getAddress());
			ps.setString(8, ud.getEmail());
			result=ps.executeUpdate();
			
			logger.info("Executed Successfully");
			
		} catch (IOException e) {
			logger.error("Exception Occured"+e.getMessage());
			throw new HotelException("IO exception occured!");
		} catch (SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
			throw new HotelException("SQL exception occured!");
		}
		
		
		
		
		return result;
	}


	public List<HotelDetails> getHotelsByName(String city,String hotel) throws HotelException {
		PropertyConfigurator.configure("log4j.properties");

		List<HotelDetails> li=null;
				li=new ArrayList<HotelDetails>();
	
		
		
		try {
			con=DBUtil.getConnection();
			String sql="select * from hotel_details where city=INITCAP(?) AND hotel_name=INITCAP(?) OR hotel_name=UPPER(?) OR hotel_name=LOWER(?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, city);
			ps.setString(2, hotel);
			ps.setString(3, hotel);
			ps.setString(4, hotel);
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
			
				
				li.add(new HotelDetails(hotelId,city1,hotelName,hotelAddress,description,avgRatePerNight,phoneNo1,phoneNo2,rating,email,fax));
				
			}
			logger.info("Executed Successfully");
		
			
		} catch (SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
			throw new HotelException(e.getMessage());
		} catch (IOException e) {
			logger.error("Exception Occured"+e.getMessage());
			throw new HotelException("IO exception occured!");
		}
		
		
		return li;
	}


	public List<HotelDetails> getHotelsByCity(String city) throws HotelException {
		
		PropertyConfigurator.configure("log4j.properties");


		List<HotelDetails> li=new ArrayList<HotelDetails>();
	
		
		
		try {
			con=DBUtil.getConnection();
			String sql="select * from hotel_details where city=INITCAP(?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, city);
			
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
				
				
				
				li.add(new HotelDetails(hotelId,city1,hotelName,hotelAddress,description,avgRatePerNight,phoneNo1,phoneNo2,rating,email,fax));
				
			}
			
			logger.info("Executed Successfully");
			
		} catch (SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
		throw new HotelException("SQL exception occured!");
		} catch (IOException e) {
			logger.error("Exception Occured"+e.getMessage());
			throw new HotelException("IO exception occured!");
		}
		
		
		return li;
	}

	
	public ArrayList<UserDetails> userAuthentication() throws HotelException {
		PropertyConfigurator.configure("log4j.properties");

		ArrayList<UserDetails> li=new ArrayList<UserDetails>();
		try {
			con=DBUtil.getConnection();
			String sql="select user_name,password from user_details";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				String user=rs.getString(1);
				String pass=rs.getString(2);
				li.add(new UserDetails(user,pass));
			}
			
			logger.info("Executed Successfully");
		} catch (IOException e) {
			logger.error("Exception Occured"+e.getMessage());
			throw new HotelException("IO exception occured!");
		} catch (SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
			throw new HotelException("SQL exception occured!");
		}
	
	
		return li;
	}

	
	public ArrayList<String> isCityInList( ) throws HotelException {
		PropertyConfigurator.configure("log4j.properties");

		ArrayList<String> li=new ArrayList<String>();
		try {
			con=DBUtil.getConnection();
			String sql="select distinct city from hotel_details";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String city1=rs.getString(1);
				li.add(city1);
			}	
			logger.info("Executed Successfully");
		
	} catch (IOException e) {
		logger.error("Exception Occured"+e.getMessage());
		throw new HotelException("IO exception occured!");
	} catch (SQLException e) {
		logger.error("Exception Occured"+e.getMessage());
		throw new HotelException("SQL exception occured!");
	}
		return li;
	}

	
	public String getUserId(UserDetails ud) throws HotelException {
		PropertyConfigurator.configure("log4j.properties");

		String userId=null;
		try {
			con=DBUtil.getConnection();
			String sql="select mobile_no from user_details where user_name=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, ud.getUserName());
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			 userId=rs.getString(1);
				
			}	
			logger.info("Executed Successfully");
		
	} catch (IOException e) {
		logger.error("Exception Occured"+e.getMessage());
		throw new HotelException("IO exception occured!");
	} catch (SQLException e) {
		logger.error("Exception Occured"+e.getMessage());
		throw new HotelException("SQL exception occured!");
	}
		System.out.println(userId);
		return userId;
	}

	@Override
	public int updateAvailability(String avail, RoomDetails res) throws HotelException {
		
		PropertyConfigurator.configure("log4j.properties");

		int availModified = 0;
		try {
			con=DBUtil.getConnection();
			String availQuery= "update room_details SET availability=? WHERE room_id=?";
			PreparedStatement psUpAvail=con.prepareStatement(availQuery);
			String roomId1=rd.getRoomId();
			int roomId2=Integer.parseInt(roomId1);
			psUpAvail.setString(1, avail);
			psUpAvail.setInt(2,roomId2);
			availModified = psUpAvail.executeUpdate();
			
			logger.info("Executed Successfully");
		} catch (IOException e) {
			
			logger.error("Exception Occured"+e.getMessage());
			throw new HotelException("IO exception occured!");
		} catch (SQLException e) {
	
			logger.error("Exception Occured"+e.getMessage());
			throw new HotelException("SQL exception occured!");
		}
		
		return availModified;
	}

	}


