package com.cg.eis.pl;

import java.util.Scanner;

public class EmployeeOperations {

	
	Scanner sc= new Scanner(System.in);
   public void getDetailsOfEmployee(Employee e)
   {
	   System.out.println("\nEnter the employee id:\n");
	   e.id=sc.nextInt();
	   System.out.println("\nEnter the employee name:\n");
	   e.name=sc.next();
	   System.out.println("\nEnter the employee salary:\n");
	   e.salary=sc.nextDouble();
	   System.out.println("\nEnter the employee designation:\n");
	   e.designation=sc.next();
   }
   public void showDetailsOfEmployee(Employee e)
   {
	   System.out.println("\nDetails of the Employee are:\n");
	   System.out.println("ID:\n"+e.id);
	   System.out.println("Name:\n"+e.name);
	   System.out.println("Salary:\n"+e.salary);
	   System.out.println("Designation:\n"+e.designation);
	   
   }
   public String getInsuranceSchemeOfEmployee(double salary)
   {
	   String scheme = null;
	   
	   if(salary<5000)
	   {
		   scheme="No Scheme";
	   }
	   else if(salary>5000)
	   {
		   scheme="Scheme C";
		   
	   }
	   else if(salary>=20000)
	   {
		   scheme="Scheme B";
	   }
	   else if(salary>=40000)
	   {
		   scheme="Scheme A"; 
	   }
	  
	   return scheme;
   }
}
