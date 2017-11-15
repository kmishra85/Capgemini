package com.cg.account.exception;

public class AccountException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String msg;
	public AccountException(String msg)
	{
		this.msg=msg;
	}
	@Override
	public String toString() {
		return "AccountException: Error Occurred, "+msg;
	}
	
	
}
