package com.cg.assessment.service;

import java.util.ArrayList;

import com.cg.assessment.bean.AssessmentDetails;
import com.cg.assessment.exception.AssessmentException;


public interface IAssessmentService {

	ArrayList<Integer> getID() throws AssessmentException;   //abstract method to fetch trainee ids

	AssessmentDetails calTotal(AssessmentDetails bean);  //to calculate total marks in service layer

	AssessmentDetails getGrade(AssessmentDetails bean1);	//to calculate grade in service layer

	int addDetails(AssessmentDetails bean2) throws AssessmentException ;	//to add details of score to database and fetch number of rows inserted!

}
