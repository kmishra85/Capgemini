package com.cg.account.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.account.bean.AccountDetails;
import com.cg.account.dbutil.DBUtil;
import com.cg.account.exception.AccountException;

public class AccountDaoImpl implements IAccountDao{
Connection con=null;
	int balance=0;
	int id=0;
	public int getBalance(AccountDetails bean) {
	
		try {
			con=DBUtil.getConnection();
			String sql="select balance from accounttable where accountid="+bean.getAccountId();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				 balance=rs.getInt(1);
			}
			
			
			
		} catch (IOException e) {
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return balance;
	}

	public AccountDetails addDetails(AccountDetails bean2) throws AccountException {
		try {
			con=DBUtil.getConnection();
			String sql="insert into accounttable values(?,?,?,tran_seq.nextval)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, bean2.getAccountId());
			ps.setString(2, bean2.getAccountType());
			ps.setInt(3,bean2.getAmount());
			ps.setInt(4, bean2.getBalance());
			ps.executeUpdate();
			
			String q="select tran_seq.CURRVAL from dual";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(q);
			while(rs.next())
			{
				
			 id=rs.getInt(1);
			}
			
			bean2.setTransactionId(id);
			
		} catch (IOException e) {
			throw new AccountException(e.getMessage());
		
		} catch (SQLException e) {
			throw new AccountException(e.getMessage());
		}
		
		
		
		return bean2;
	}

	
	public ArrayList<Integer> getId() {
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		try {
			con=DBUtil.getConnection();
			String sql="select accountid from userinfo";
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery(sql);	
			while(rs.next())
			{
				int id=rs.getInt(1);
				list.add(id);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}

}
