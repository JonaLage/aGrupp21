package org.lu.ics.labs;

import java.util.ArrayList;


public class Customer {
	
	private String cNumber; 
	private String cName;
	private ArrayList<Account> accountList = new ArrayList<Account>();
	
	public String getCNumber() { 
		return this.cNumber;
	}
	public void setCNumber(String cNumber) { 
		this.cNumber = cNumber;
	}
	public String getCName() { 
		return this.cName;
	}
	public void setCName(String cName) { 
		this.cName = cName;
	}
	
	public ArrayList<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	public void addAccount(Account account) {
		accountList.add(account);
	}
	public Account findAccount(int accountNbr) {
		for(Account a: accountList) {
			if(a.getNbr() == (accountNbr)) { 
				return a;
			}
		}
		return null;
	}
	public double totBalance() {
		double tot  = 0;
		for(Account acc: accountList)  {
			tot += acc.getBalance();
		}
		return tot;
	}
	public Customer(String cNumber, String cName) {
		this.setCNumber(cNumber);
		this.setCName(cName);
	}
}
