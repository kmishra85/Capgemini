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
import com.cg.cheapstays.bean.EmployeeDetails;
import com.cg.cheapstays.bean.HotelDetails;
import com.cg.cheapstays.bean.RoomDetails;
import com.cg.cheapstays.bean.UserDetails;
import com.cg.cheapstays.dbutil.DBUtil;
import com.cg.cheapstays.exception.HotelException;

public class DaoEmployeeImpl implements IDaoEmployee{
	Logger logger = Logger.getRootLogger();
	Connection con=null;
	
	@Override
	public ArrayList<EmployeeDetails> empAuthentication() throws IOException, SQLException {
		PropertyConfigurator.configure("log4j.properties");
		ArrayList<EmployeeDetails> empList=new ArrayList<EmployeeDetails>();
		
		con=DBUtil.getConnection();
		//System.out.println(con);
		String sql="select emp_username,emp_password from emp_details";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			String user=rs.getString(1);
			String pass=rs.getString(2);
			empList.add(new EmployeeDetails(user,pass));
		}
		//System.out.println("dao"+empList);
		return empList;
	}

	@Override
	public ArrayList<String> isCityInList() throws HotelException {
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
			logger.info("Values fetched from hotel_details table");
		
	} catch (IOException e) {
		logger.error("Exception Occured"+e.getMessage());
	//	throw new HotelException("IO exception occured!");
	
	} catch (SQLException e) {
		logger.error("Exception Occured"+e.getMessage());
	
	//	throw new HotelException("SQL exception occured!");
	}
		return li;
	}

	@Override
	public List<HotelDetails> getHotelsByName(String city, String hotelName) throws HotelException {
		PropertyConfigurator.configure("log4j.properties");
		List<HotelDetails> li=null;
		li=new ArrayList<HotelDetails>();
try {
	con=DBUtil.getConnection();
	String sql="select * from hotel_details where city=INITCAP(?) and hotel_name=INITCAP(?)";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, city);
	ps.setString(2, hotelName);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{

		String hotelId=rs.getString(1);
		String city1=rs.getString(2);
		String hotel=rs.getString(3);
		String hotelAddress=rs.getString(4);
		String description=rs.getString(5);
		float avgRatePerNight=rs.getFloat(6);
		String phoneNo1=rs.getString(7);
		String phoneNo2=rs.getString(8);
		String rating=rs.getString(9);
		String email=rs.getString(10);
		String fax=rs.getString(11);
		
		li.add(new HotelDetails(hotelId,city1,hotel,hotelAddress,description,avgRatePerNight,phoneNo1,phoneNo2,rating,email,fax));
		
	}
	logger.info("Values fetched from hotel_details table");
	
} catch (SQLException e) {
	logger.error("Exception Occured"+e.getMessage());
//	throw new HotelException("SQl exception occured!");
} catch (IOException e) {
	logger.error("Exception Occured"+e.getMessage());
//	throw new HotelException("IO exception occured!");
}

return li;
}

	@Override
	public int empAddBooking(BookingDetails bd, UserDetails ud,String hotelId,String roomType,long dayBetween) throws HotelException {
		PropertyConfigurator.configure("log4j.properties");
		int roomId=0;
		float amount=0;
		String roomNo=null;
		try {
			String user=null;
			RoomDetails rd=new RoomDetails();
			con=DBUtil.getConnection();
			String q="select user_id from user_details where mobile_no=?";
			PreparedStatement ps1=con.prepareStatement(q);

			ps1.setString(1,ud.getMobileNo());
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				 user=rs.getString(1);
			}
		System.out.println("Your User ID : "+user);
		System.out.println("Hotel ID:"+hotelId);
		
		String getSeqRoomId = "SELECT room_id,per_night_rate,room_no FROM room_details where hotel_id =? and room_type=? and availability='Y'";
		PreparedStatement ps2=con.prepareStatement(getSeqRoomId);

		ps2.setString(1,hotelId);
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
			
			ps.setInt(1,roomId);
			ps.setDate(2,bd.getBookedFrom());
			ps.setDate(3, bd.getBookedTo());
			ps.setInt(4, bd.getNoOfAdults());
			ps.setInt(5, bd.getNoOfChildren());
			ps.setFloat(6, amount);
			ps.setString(7, user);
			
			ps.executeUpdate();
			
			logger.info("Executed Successfully");	
		} catch (IOException e) {
		
			logger.error("Exception Occured"+e.getMessage());
	//		throw new HotelException("IO exception occured!");

		} catch (SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("SQL exception occured!");

		}
		System.out.println("ID is "+roomId);
				return roomId;
		}

	@Override
	public List<HotelDetails> empGetHotelsByCity(String city) throws HotelException {
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
			logger.info("Values fetched from hotel_details table");
		} catch (SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("SQL exception occured!");

		} catch (IOException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("IO exception occured!");

		}
		
		return li;
	}

	@Override
	public int addRooms(RoomDetails roomDetails) throws HotelException {
		PropertyConfigurator.configure("log4j.properties");
		int roomsAdded = 0;
		try {
			con=DBUtil.getConnection();
			String insertRooms = "insert into room_details values(?,room_id_seq.nextval,?,?,?,?)";
			PreparedStatement ps1=con.prepareStatement(insertRooms);
			
			ps1.setString(1,roomDetails.getHotelId());
			ps1.setString(2,roomDetails.getRoomNo());
			ps1.setString(3,roomDetails.getRoomType());
			ps1.setFloat(4,roomDetails.getPer_night_rate());
			ps1.setString(5,roomDetails.isAvailability());
			roomsAdded=ps1.executeUpdate();
			logger.info("Values inserted in room_details table");
		} catch (IOException | SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("IO or SQL exception occured!");
		}
		
		
		return roomsAdded;
	}

	@Override
	public int deleteRoom(int delRoom) throws HotelException 
	{
		PropertyConfigurator.configure("log4j.properties");
		int roomsDeleted = 0;
		try {
			con=DBUtil.getConnection();
			String insertRooms = "Delete from room_details where room_no=?";
			PreparedStatement ps1=con.prepareStatement(insertRooms);
			
			ps1.setInt(1,delRoom);
			roomsDeleted=ps1.executeUpdate();
			logger.info("Values deleted from room_details table");
		} catch (IOException | SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("IO or SQL exception occured!");
		}
		return roomsDeleted;
	}

	@Override
	public int modifyRoomType(int roomNumber,String roomType,int roomRate) throws HotelException {
		PropertyConfigurator.configure("log4j.properties");
		int roomModified =0;
		try {
			
			con=DBUtil.getConnection();
			String typeQuery="UPDATE room_details SET room_type = ?,per_night_rate=? WHERE room_no=?";
			PreparedStatement psUpdate=con.prepareStatement(typeQuery);
			psUpdate.setString(1,roomType);
			psUpdate.setInt(2, roomRate);
			psUpdate.setInt(3, roomNumber);
			roomModified = psUpdate.executeUpdate();
			logger.info("Values updated in room_details table");
		} catch (IOException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("IO exception occured!");
		} catch (SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("SQL exception occured!");
		}
		
		return roomModified;
	}

	@Override
	public int modifyRoomRate(int roomNumber, int roomRate,int hotelId) throws HotelException {
		PropertyConfigurator.configure("log4j.properties");
		int rateModified=0;
		try {
			con=DBUtil.getConnection();
			String typeQuery="UPDATE room_details SET per_night_rate=? WHERE room_no=? and hotel_id=?";
			PreparedStatement psUpdate=con.prepareStatement(typeQuery);
			psUpdate.setInt(1, roomRate);
			psUpdate.setInt(2, roomNumber);
			psUpdate.setInt(3, hotelId);
			rateModified = psUpdate.executeUpdate();
			logger.info("Values updated in room_details table");
		} catch (IOException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("IO exception occured!");
		} catch (SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("SQL exception occured!");
		}
		
		return rateModified;
	}

	@Override
	public int modifyAvailability(int id, int roomNo, String avail) throws HotelException {
		PropertyConfigurator.configure("log4j.properties");
		int availModified = 0;
		try {
			con=DBUtil.getConnection();
			String availQuery= "update room_details SET availability=? WHERE hotel_id=? and room_no=?";
			PreparedStatement psUpAvail=con.prepareStatement(availQuery);
			psUpAvail.setString(1, avail);
			psUpAvail.setInt(2,id);

			psUpAvail.setInt(3,roomNo);
			availModified = psUpAvail.executeUpdate();
			logger.info("Values updated in room_details table");
		} catch (IOException e) {
			
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("IO exception occured!");
		} catch (SQLException e) {
		
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("SQL exception occured!");
		}
		
		return availModified;
		
	}

	@Override
	public int updateAvailability(String avail,int roomId) throws HotelException {
		PropertyConfigurator.configure("log4j.properties");
		int availModified = 0;
		try {
			con=DBUtil.getConnection();
			String availQuery= "update room_details SET availability=? WHERE room_id=?";
			PreparedStatement psUpAvail=con.prepareStatement(availQuery);
			psUpAvail.setString(1, avail);
			psUpAvail.setInt(2,roomId);
			availModified = psUpAvail.executeUpdate();
			logger.info("Values updated in room_details table");
		} catch (IOException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("IO exception occured!");
		} catch (SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("SQL exception occured!");
		}
		
		return availModified;
	}

	@Override
	public boolean validateHotelId(int id) throws HotelException {
		PropertyConfigurator.configure("log4j.properties");
		boolean flag=false;		
		String validateIdQuery="SELECT * FROM room_details ";
		ArrayList<Integer> hotelIDs = new ArrayList<Integer>();
		try {
			PreparedStatement ps=con.prepareStatement(validateIdQuery);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int number=rs.getInt(1);
				hotelIDs.add(number);
			}
			//System.out.println(roomNos);
			for(Integer no : hotelIDs){
				if(no==id){
					flag=true;
					break;
				}
			}
			logger.info("Values fetched from room_details table");
		} catch (SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("SQL exception occured!");
		}
		
		return flag;
	}
	@Override
	public boolean validateRoomNumber(int roomNumber,int hotelId) throws HotelException {
		PropertyConfigurator.configure("log4j.properties");
	boolean flag=false;		
		String validateNumberQuery="SELECT * FROM room_details where hotel_id=?";
		ArrayList<Integer> roomNos = new ArrayList<Integer>();
		try {
			PreparedStatement ps=con.prepareStatement(validateNumberQuery);
			ps.setInt(1,hotelId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int number=rs.getInt(3);
				roomNos.add(number);
			}
			//System.out.println(roomNos);
			for(Integer no : roomNos){
				if(no==roomNumber){
					flag=true;
					break;
				}
			}
			logger.info("Values fetched from room_details table");
		} catch (SQLException e) {
			logger.error("Exception Occured"+e.getMessage());
		//	throw new HotelException("SQL exception occured!");
		}
		
		return flag;
	}



}


