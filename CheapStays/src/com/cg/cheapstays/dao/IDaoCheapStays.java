package com.cg.cheapstays.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.cheapstays.bean.BookingDetails;
import com.cg.cheapstays.bean.HotelDetails;
import com.cg.cheapstays.bean.UserDetails;

public interface IDaoCheapStays {

	int addBooking(BookingDetails bd,UserDetails ud);

	int addRegister(UserDetails ud);

	List<HotelDetails> getHotelsByName(String city,String hotelName);

	List<HotelDetails> getHotelsByCity(String city);

	ArrayList<UserDetails> userAuthentication();

	ArrayList<String> isCityInList( );

	String getUserId(UserDetails ud);


}
