package com.cg.cheapstays.bean;

public class EmployeeDetails {

	private String empUserName;
	private String empPassword;
	
	public String getEmpUserName() {
		return empUserName;
	}
	public void setEmpUserName(String empUserName) {
		this.empUserName = empUserName;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	
	public EmployeeDetails(String empUserName, String empPassword) {
		super();
		this.empUserName = empUserName;
		this.empPassword = empPassword;
	}
	
	public EmployeeDetails(){
		
	}
	@Override
	public String toString() {
		return "EmployeeDetails [empUserName=" + empUserName + ", empPassword="
				+ empPassword + "]";
	}
	
	
}
