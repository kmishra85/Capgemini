package com.cg.assessment.bean;

public class AssessmentDetails {

	private int traineeId;
	private String moduleName;
	private int mpt;
	private int mtt;
	private int assignment;
	private int totalMarks;
	private int grade;
	
	/*
	*********************************************************************
	* Module Name         	: AssessmentDetails()
	* Input Parameters     	: void
	* Return Type         	: void
	* Author              	: Keshav Mishra
	* Creation Date      	: 11-Oct-2017
	* Description        	: Default Constructor
	 *********************************************************************
	*/	
	
	public AssessmentDetails()
	{
		
	}
	/*
	*********************************************************************
	* Module Name         	: AssessmentDetails()
	* Input Parameters     	: traineeId,moduleName,mpt,mtt,assignment,totalMarks,grade
	* Return Type         	: AssessmentDetails
	* Author              	: Keshav Mishra
	* Creation Date      	: 11-Oct-2017
	* Description        	: parameterized constructor
	 *********************************************************************
	*/	
	
	
	public AssessmentDetails(int traineeId, String moduleName, int mpt,
			int mtt, int assignment, int totalMarks, int grade) {
		super();
		this.traineeId = traineeId;
		this.moduleName = moduleName;
		this.mpt = mpt;
		this.mtt = mtt;
		this.assignment = assignment;
		this.totalMarks = totalMarks;
		this.grade = grade;
	}
	public int getTraineeId() {						//getter and setter methods
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public int getMpt() {
		return mpt;
	}
	public void setMpt(int mpt) {
		this.mpt = mpt;
	}
	public int getMtt() {
		return mtt;
	}
	public void setMtt(int mtt) {
		this.mtt = mtt;
	}
	public int getAssignment() {
		return assignment;
	}
	public void setAssignment(int assignment) {
		this.assignment = assignment;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/*
	*********************************************************************
	* Module Name         	: toString()
	* Input Parameters     	: void
	* Return Type         	: Srring
	* Author              	: Keshav Mishra
	* Creation Date      	: 11-Oct-2017
	* Description        	: To print the bean object
	 *********************************************************************
	*/	

	@Override
	public String toString() {
		return "AssessmentDetails [traineeId=" + traineeId + ", moduleName="
				+ moduleName + ", mpt=" + mpt + ", mtt=" + mtt
				+ ", assignment=" + assignment + ", totalMarks=" + totalMarks
				+ ", grade=" + grade + "]";
	}
	
	
	
	
}
