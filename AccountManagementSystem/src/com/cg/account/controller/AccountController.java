package com.cg.account.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.account.bean.AccountDetails;
import com.cg.account.exception.AccountException;
import com.cg.account.service.AccountServiceImpl;
import com.cg.account.service.IAccountService;

@WebServlet("*.obj")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String target=null;
       AccountDetails bean=new AccountDetails();
     IAccountService service=new AccountServiceImpl();  
     ArrayList<Integer> li=new ArrayList<Integer>();
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		
		String path=request.getServletPath();
		switch(path)
		{
		case "/withdraw.obj":
			li=service.getId();
			System.out.println(li);
			session.setAttribute("output", li);
			target="AccountProcessing.jsp";
			
		break;
		case "/result.obj":
		
			
			String accountType=request.getParameter("type");
			int amountToWithdraw=Integer.parseInt(request.getParameter("amount"));
			
			String accountId=request.getParameter("id");
			if(accountId!=null)
			{
				int accountId1=Integer.parseInt(accountId);
				
				System.out.println(accountId1);
				bean.setAccountId(accountId1);
				bean.setAccountType(accountType);
				bean.setAmount(amountToWithdraw);
				
				AccountDetails bean2=service.getBalance(bean);
				AccountDetails bean3;
				try {
					bean3 = service.addDetails(bean2);
					session.setAttribute("bean", bean3);
				} catch (AccountException e) {
					session.setAttribute("exception", e.getMessage());
				}
				
				
			
				
			}
			else
			{
				try {
					throw new AccountException("Invalid Account ID");
				} catch (AccountException e) {
					
					session.setAttribute("accountID", e.getMessage());
				}
			}
			target="result.jsp";
		break;
		}
		System.out.println(target);
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
