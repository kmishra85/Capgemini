package com.cg.cheapstays.dao;

import java.util.ArrayList;

import com.cg.cheapstays.bean.AdminDetails;
import com.cg.cheapstays.bean.HotelDetails;
import com.cg.cheapstays.exception.HotelException;

public interface IDaoAdmin {

	public ArrayList<AdminDetails> adminAuthentication();

	public int addNewHotels(HotelDetails hDetails) throws HotelException;

	public ArrayList<HotelDetails> retrieveDetails() throws HotelException;

	public int deleteById(String deleteId) throws HotelException;

	public int updateById(HotelDetails hd) throws HotelException;

	public HotelDetails retrieveById(String updateId) throws HotelException;

	public ArrayList<String> validateUserName() throws HotelException;

	public ArrayList<String> validatePassword() throws HotelException;

	
}
