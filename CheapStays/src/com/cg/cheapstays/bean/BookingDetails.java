package com.cg.cheapstays.bean;

import java.sql.Date;


public class BookingDetails {

	private String bookingId;
	private String roomId;
	private String userId;
	private Date bookedFrom;
	private Date bookedTo;
	private int noOfAdults;
	private int noOfChildren;
	private float amount;
	
	public BookingDetails() {
		
	}
	
	

	public BookingDetails(String bookingId, String roomId, String userId,
			Date bookedFrom, Date bookedTo, int noOfAdults, int noOfChildren,
			float amount) {
		super();
		this.bookingId = bookingId;
		this.roomId = roomId;
		this.userId = userId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
		this.noOfAdults = noOfAdults;
		this.noOfChildren = noOfChildren;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", roomId=" + roomId
				+ ", userId=" + userId + ", bookedFrom=" + bookedFrom
				+ ", bookedTo=" + bookedTo + ", noOfAdults=" + noOfAdults
				+ ", noOfChildren=" + noOfChildren + ", amount=" + amount + "]";
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(Date df1) {
		this.bookedFrom = (Date) df1;
	}

	public Date getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(Date bookedTo) {
		this.bookedTo = bookedTo;
	}

	public int getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public int getNoOfChildren() {
		return noOfChildren;
	}

	public void setNoOfChildren(int noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	


	
}
