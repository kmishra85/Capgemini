package com.cg.assessment.exception;

public class AssessmentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	*********************************************************************
	* Module Name         	: AssessmentException()
	* Input Parameters     	: msg
	* Return Type         	: void
	* Author              	: Keshav Mishra
	* Creation Date      	: 11-Oct-2017
	* Description        	: To initialize error message
	 *********************************************************************
	*/	
	String msg=null;
	public AssessmentException(String msg)
	{
		this.msg=msg;
		
	}
	
	/*
	*********************************************************************
	* Module Name         	: toString()
	* Input Parameters     	: void
	* Return Type         	: String
	* Author              	: Keshav Mishra
	* Creation Date      	: 11-Oct-2017
	* Description        	: To print the object of exception class
	 *********************************************************************
	*/	
	@Override
	public String toString() {
		return "AssessmentException: Error Occurresd due to exception"+msg;
	}
	
	
}
