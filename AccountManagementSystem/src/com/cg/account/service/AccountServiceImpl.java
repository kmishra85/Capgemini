package com.cg.account.service;

import java.util.ArrayList;

import com.cg.account.bean.AccountDetails;
import com.cg.account.dao.AccountDaoImpl;
import com.cg.account.dao.IAccountDao;
import com.cg.account.exception.AccountException;

public class AccountServiceImpl implements IAccountService{
int balance=1000;
	IAccountDao dao =new AccountDaoImpl();
	
	public AccountDetails getBalance(AccountDetails bean) {
		
		int amount=bean.getAmount();
		//int balance=dao.getBalance(bean);
		balance=balance-amount;
		bean.setBalance(balance);
		
		return bean;
	}
	
	public AccountDetails addDetails(AccountDetails bean2) throws AccountException {
		
		
		
		return dao.addDetails(bean2);
	}


	public ArrayList<Integer> getId() {
	
		
		return dao.getId();
	}

}
