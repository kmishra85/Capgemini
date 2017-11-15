package com.cg.assessment.service;

import java.util.ArrayList;

import com.cg.assessment.bean.AssessmentDetails;
import com.cg.assessment.dao.AssessmentDaoImpl;
import com.cg.assessment.dao.IAssessmentDao;
import com.cg.assessment.exception.AssessmentException;


public class AssessmentServiceImpl implements IAssessmentService{

	
	
	
/*
*********************************************************************
* Module Name         	: getID()
* Input Parameters     	: void
* Return Type         	: ArrayList<Integer>
* Author              	: Keshav Mishra
* Creation Date      	: 11-Oct-2017
* Description        	: To fetch the trainee ids from database
 *********************************************************************
*/	
	IAssessmentDao dao=new AssessmentDaoImpl();
	public ArrayList<Integer> getID() throws AssessmentException {
		
		return dao.getID();
	}
	
	/*
	*********************************************************************
	* Module Name         	: calTotal()
	* Input Parameters     	: bean
	* Return Type         	: AssessmentDetails
	* Author              	: Keshav Mishra
	* Creation Date      	: 11-Oct-2017
	* Description        	: To calculate the total marks in service layer
	 *********************************************************************
	*/		

	
	public AssessmentDetails calTotal(AssessmentDetails bean) {
		
		int total=bean.getMpt()+bean.getMtt()+bean.getAssignment();
		bean.setTotalMarks(total);
		return bean;
	}
	/*
	*********************************************************************
	* Module Name         	: getGrade()
	* Input Parameters     	: bean1
	* Return Type         	: AssessmentDetails
	* Author              	: Keshav Mishra
	* Creation Date      	: 11-Oct-2017
	* Description        	: To calculate the grade in service layer
	 *********************************************************************
	*/		

	
	public AssessmentDetails getGrade(AssessmentDetails bean1) {
		
		int total=bean1.getTotalMarks();
		
		if(total<=100 && total>=90)
		{
			bean1.setGrade(5);
		}
		else if(total>=80)
		{
			bean1.setGrade(4);
		}
		else if(total>=70)
		{
			bean1.setGrade(3);
		}
		else if(total>=60)
		{
			bean1.setGrade(2);
		}
		else if(total>=50)
		{
			bean1.setGrade(1);
		}
		else
		{
			
			bean1.setGrade(0);
		}
		
		return bean1;
	}

	
	
/*
*********************************************************************
* Module Name         	: addDetails()
* Input Parameters     	: bean2
* Return Type         	: int
* Author              	: Keshav Mishra
* Creation Date      	: 11-Oct-2017
* Description        	: To add details of marks and grade to the database
 *********************************************************************
*/	
	public int addDetails(AssessmentDetails bean2) throws AssessmentException  {
		
		
		
		return dao.addDetails(bean2);
	}

}
