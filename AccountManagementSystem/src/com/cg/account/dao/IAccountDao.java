package com.cg.account.dao;

import java.util.ArrayList;

import com.cg.account.bean.AccountDetails;
import com.cg.account.exception.AccountException;

public interface IAccountDao {

	int getBalance(AccountDetails bean);

	AccountDetails addDetails(AccountDetails bean2) throws AccountException;

	ArrayList<Integer> getId();

}
