package com.cg.account.bean;

public class AccountDetails {

	
	private int accountId;
	private String accountType;
	private int amount;
	private int balance;
	private int transactionId;
	
	
	public AccountDetails()
	{
		
		
	}
	
	

	
	
	public AccountDetails(int accountId, String accountType, int amount,
			int balance, int transactionId) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.amount = amount;
		this.balance = balance;
		this.transactionId = transactionId;
	}





	public int getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}


	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "AccountDetails [accountId=" + accountId + ", accountType="
				+ accountType + ", amount=" + amount + ", balance=" + balance
				+ "]";
	}
	
	
	
	
}
