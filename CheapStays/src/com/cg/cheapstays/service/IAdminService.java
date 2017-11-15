package com.cg.cheapstays.service;

import java.util.ArrayList;

import com.cg.cheapstays.bean.AdminDetails;
import com.cg.cheapstays.bean.HotelDetails;
import com.cg.cheapstays.exception.HotelException;

public interface IAdminService {

	public int adminAuthentication(AdminDetails adm);

	public int addNewHotels(HotelDetails hDetails) throws HotelException;

	public ArrayList<HotelDetails> retrieveDetails() throws HotelException;

	public int deleteById(String deleteId) throws HotelException;

	public int updateById(HotelDetails hd) throws HotelException;

	public HotelDetails retrieveById(String updateId) throws HotelException;

	public boolean validateUserName(String setAdminUsername) throws HotelException;

	public boolean validatePassword(String adminPassword) throws HotelException;


	



	



}
