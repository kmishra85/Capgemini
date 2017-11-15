package com.cg.cheapstays.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.cheapstays.bean.BookingDetails;
import com.cg.cheapstays.bean.EmployeeDetails;
import com.cg.cheapstays.bean.HotelDetails;
import com.cg.cheapstays.bean.RoomDetails;
import com.cg.cheapstays.bean.UserDetails;
import com.cg.cheapstays.exception.HotelException;

public interface IDaoEmployee {

	ArrayList<EmployeeDetails> empAuthentication() throws IOException, SQLException;

	ArrayList<String> isCityInList() throws HotelException;

	List<HotelDetails> getHotelsByName(String city, String hotelName) throws HotelException;

	int empAddBooking(BookingDetails bd, UserDetails ud,String hotelId, String roomType,long dayBetween) throws HotelException;

	List<HotelDetails> empGetHotelsByCity(String city) throws HotelException;

	int addRooms(RoomDetails roomDetails) throws HotelException;

	int deleteRoom(int delRoom) throws HotelException;

	int modifyRoomType(int roomNumber,String roomType,int roomRate) throws HotelException;

	int modifyRoomRate(int roomNumber, int roomRate, int hotelId) throws HotelException;

	int modifyAvailability(int id, int roomNo, String avail) throws HotelException;

	int updateAvailability(String avail, int getSeq) throws HotelException;

	boolean validateRoomNumber(int roomNumber, int hotelId) throws HotelException;

	boolean validateHotelId(int id) throws HotelException;




}