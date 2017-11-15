package com.cg.assessment.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.assessment.bean.AssessmentDetails;
import com.cg.assessment.exception.AssessmentException;
import com.cg.assessment.service.AssessmentServiceImpl;
import com.cg.assessment.service.IAssessmentService;

@WebServlet("*.obj")
public class AssessmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	String target=null;
	int res;
	int flag=0;
	IAssessmentService service=new AssessmentServiceImpl();
	ArrayList<Integer> li=new ArrayList<Integer>();
	AssessmentDetails bean=new AssessmentDetails(); 
   

	/*
	*********************************************************************
	* Module Name         	: doGet()
	* Input Parameters     	: request,response
	* Return Type         	: Connection
	* Author              	: Keshav Mishra
	* Creation Date      	: 11-Oct-2017
	* Description        	: To process the jsp requests as the servlet requests
	 *********************************************************************
	*/	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		HttpSession session=request.getSession();
		switch(path)
		{
		
		case "/addAssessment.obj":
			try {
				li=service.getID();

				System.out.println(li);
				session.setAttribute("output", li);
				
				target="AddAssessment.jsp";
			} catch (AssessmentException e) {
				flag=1;
				System.out.println(e);
				session.setAttribute("getIDException", e);
				target="error.jsp";
			}
			break;
			
		case "/ModuleScore.obj":
			
			String id=request.getParameter("id");
			String module=request.getParameter("module");
			String mpt=request.getParameter("mpt");
			String mtt=request.getParameter("mtt");
			String assignment=request.getParameter("assignment");
			
		
			
			
			int id1=Integer.parseInt(id);
			int mpt1=Integer.parseInt(mpt);
			int mtt1=Integer.parseInt(mtt);
			int assignment1=Integer.parseInt(assignment);
			
			bean.setTraineeId(id1);;
			bean.setModuleName(module);
			bean.setMpt(mpt1);
			bean.setMtt(mtt1);
			bean.setAssignment(assignment1);
			
			
			AssessmentDetails bean1=service.calTotal(bean);
			AssessmentDetails bean2=service.getGrade(bean1);
			
			
			try {
				res = service.addDetails(bean2);
				if(res==1)
				{
					session.setAttribute("bean", bean2);
					session.setAttribute("Id", bean2.getTraineeId());
					target="ModuleScore.jsp";	
				}
				else
				{
					target="error.jsp";
				}
				
				
				
			} catch (AssessmentException e) {
				flag=1;
				System.out.println(e);
				session.setAttribute("addException", e);
				target="error.jsp";
			}
				
			
			break;
		}
		if(flag==1)
		{
			RequestDispatcher rd=request.getRequestDispatcher(target);
			rd.include(request, response);		
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher(target);
			rd.forward(request, response);
		}
	}

}
