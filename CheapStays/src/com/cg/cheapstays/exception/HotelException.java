package com.cg.cheapstays.exception;

public class HotelException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String msg;
	public HotelException(String msg)
	{
		this.msg=msg;
	}
	@Override
	public String toString() {
		return "HotelException [msg=" + msg + "]";
	}
	
	
}
