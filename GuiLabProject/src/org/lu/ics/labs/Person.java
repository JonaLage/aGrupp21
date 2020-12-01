package org.lu.ics.labs;

import java.util.ArrayList;

public class Person {

	private String pNbr;
	private String name;
	private ArrayList<Account> accounts = new ArrayList<Account>();

	public String getpNbr() {
		return pNbr;
	}

	public void setpNbr(String pNbr) {
		this.pNbr = pNbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(Account account) {
		this.accounts.add(account);
	}

	public Account findAccount(String accountNbr) {
		for (Account a : accounts) {
			if (a.getAccountNbr().equals(accountNbr)) {
				return a;
			}
		}
		return null;
	}

	public double totalBalance() {
		double tot = 0;
		for (Account tmp : accounts) {
			tot += tmp.getBalance();
		}
		return tot;
	}

	public Person(String pNbr, String name) {
		this.pNbr = pNbr;
		this.name = name;
	}

	
	

}
