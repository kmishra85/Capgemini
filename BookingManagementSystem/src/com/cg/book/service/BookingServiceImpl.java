package com.cg.book.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.book.dao.IBookingDao;
import com.cg.book.model.Book;

@Service
@Transactional
public class BookingServiceImpl implements IBookingService{

	@Autowired
	IBookingDao dao;
	
	@Override
	public Book addDetails(Book book) {
		// TODO Auto-generated method stub
		return dao.addDetails(book);
	}

}
