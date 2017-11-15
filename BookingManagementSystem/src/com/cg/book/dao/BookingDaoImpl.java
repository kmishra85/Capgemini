package com.cg.book.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.book.model.Book;

@Repository
public class BookingDaoImpl implements IBookingDao{


	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Book addDetails(Book book) {
		// TODO Auto-generated method stub
		
		entityManager.persist(book);
		entityManager.flush();
		return book;
	}

}
