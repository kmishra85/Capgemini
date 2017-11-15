package com.cg.assessment.dao;

import java.util.ArrayList;

import com.cg.assessment.bean.AssessmentDetails;
import com.cg.assessment.exception.AssessmentException;


public interface IAssessmentDao {

	ArrayList<Integer> getID() throws AssessmentException;		//abstract method to fetch trainee ids

	int addDetails(AssessmentDetails bean2) throws AssessmentException ;		//to add details to the database

}
