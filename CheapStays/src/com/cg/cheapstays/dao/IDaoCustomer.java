package com.cg.cheapstays.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.cheapstays.bean.BookingDetails;
import com.cg.cheapstays.bean.HotelDetails;
import com.cg.cheapstays.bean.RoomDetails;
import com.cg.cheapstays.bean.UserDetails;
import com.cg.cheapstays.exception.HotelException;

public interface IDaoCustomer {

	RoomDetails addBooking(BookingDetails bd,UserDetails ud,String hotelId1,String roomType,long dayBetween) throws HotelException;

	int addRegister(UserDetails ud) throws HotelException;

	List<HotelDetails> getHotelsByName(String city,String hotelName) throws HotelException;

	List<HotelDetails> getHotelsByCity(String city) throws HotelException;

	ArrayList<UserDetails> userAuthentication() throws HotelException;

	ArrayList<String> isCityInList( ) throws HotelException;

	String getUserId(UserDetails ud) throws HotelException;

	int updateAvailability(String avail, RoomDetails res) throws HotelException;


}