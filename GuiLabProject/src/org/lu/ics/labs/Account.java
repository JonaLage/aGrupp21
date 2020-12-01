package org.lu.ics.labs;

public class Account {

	private String accountNbr;
	private double balance;
	private Person holder;

	public void setAccountNbr(String accountNbr) {
		this.accountNbr = accountNbr;
	}

	public String getAccountNbr() {
		return accountNbr;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setHolder(Person value) {
		this.holder = value;
	}

	public Person getHolder() {
		return this.holder;
	}

	public String credit(double amountIn) {
		balance += amountIn;
		return null;
	}

	public String debit(double amountOut) {
		balance -= amountOut;
		return null;
	}
	public boolean canDebit(double anAmount)
	{
	return anAmount <= balance;
	}

	public Account(String accountNbr) {
		this.accountNbr = accountNbr;
	}

	@Override
	public String toString() {
		return this.accountNbr+" "+this.getBalance();
	}

}
