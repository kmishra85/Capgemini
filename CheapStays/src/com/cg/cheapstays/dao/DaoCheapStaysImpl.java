package com.cg.cheapstays.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.cheapstays.bean.BookingDetails;
import com.cg.cheapstays.bean.HotelDetails;
import com.cg.cheapstays.bean.UserDetails;
import com.cg.cheapstays.dbutil.DBUtil;

public class DaoCheapStaysImpl implements IDaoCheapStays{
Connection con=null;
int result=0;
static UserDetails ud=new UserDetails();
	public int addBooking(BookingDetails bd,UserDetails ud) 
	{
		

		try {
			String user=null;
			con=DBUtil.getConnection();
			String q="select user_id from user_details where mobile_no=?";
			PreparedStatement ps1=con.prepareStatement(q);

			//Statement =con.createStatement();
			ps1.setString(1,ud.getMobileNo());
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				 user=rs.getString(1);
			}
			//System.out.println(ud);
			System.out.println("Your User ID : "+user);
			String query="insert into booking_details values(book_seq.nextval,'1',?,?,?,?,600.50,?)";
			PreparedStatement ps=con.prepareStatement(query);
		
		
			ps.setDate(1,bd.getBookedFrom());
			ps.setDate(2, bd.getBookedTo());
			ps.setInt(3, bd.getNoOfAdults());
			ps.setInt(4, bd.getNoOfChildren());
			ps.setString(5, user);
			result=ps.executeUpdate();
			
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return result;	
	}

	@Override
	public int addRegister(UserDetails ud) {
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
		
			/*private String userId; 
			private String password; 
			private String role;
			private String userName;
			private String mobileNo;
			private String phone;
			private String address;
			private String email;*/
			
			ps.setInt(1,seq);
			ps.setString(2,ud.getPassword());
			ps.setString(3, ud.getRole());
			ps.setString(4, ud.getUserName());
			ps.setString(5, ud.getMobileNo());
			ps.setString(6, ud.getPhone());
			ps.setString(7, ud.getAddress());
			ps.setString(8, ud.getEmail());
			result=ps.executeUpdate();
			
		
			
		} catch (IOException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return result;
	}


	public List<HotelDetails> getHotelsByName(String city,String hotel) {
		
		List<HotelDetails> li=null;
				li=new ArrayList<HotelDetails>();
	
		
		
		try {
			con=DBUtil.getConnection();
			String sql="select * from hotel_details where city=INITCAP(?) and hotel_name=INITCAP(?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, city);
			ps.setString(2, hotel);
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
				
				/*hd.setHotelId(rs.getString(1));
				hd.setCity(rs.getString(2));
				hd.setHotelName(rs.getString(3));
				hd.setAddress(rs.ge);*/
				
				li.add(new HotelDetails(hotelId,city1,hotelName,hotelAddress,description,avgRatePerNight,phoneNo1,phoneNo2,rating,email,fax));
				
			}
			
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return li;
	}


	public List<HotelDetails> getHotelsByCity(String city) {


		List<HotelDetails> li=new ArrayList<HotelDetails>();
	//	HotelDetails hd=new HotelDetails();
	
		
		
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
				
				/*hd.setHotelId(rs.getString(1));
				hd.setCity(rs.getString(2));
				hd.setHotelName(rs.getString(3));
				hd.setAddress(rs.ge);*/
				
				li.add(new HotelDetails(hotelId,city1,hotelName,hotelAddress,description,avgRatePerNight,phoneNo1,phoneNo2,rating,email,fax));
				
			}
			
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return li;
	}

	
	public ArrayList<UserDetails> userAuthentication() {
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
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	
		return li;
	}

	
	public ArrayList<String> isCityInList( ) {
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
		
	} catch (IOException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		return li;
	}

	
	public String getUserId(UserDetails ud) {
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
		
	} catch (IOException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		System.out.println(userId);
		return userId;
	}


}
