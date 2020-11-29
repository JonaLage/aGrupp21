package org.lu.ics.labs;

public class Account {
	/*A class attribute which is used by the 
	 * class to allocate a unique account number
	 *  to each object that it creates. 
	 *  Account numbers will begin at 1001  */	
	static int NEXTNUMBER = 1001;
	private int nbr;
	//private String type;
	private double balance;
	
	private Customer holder;
	/* The constructor method */
	/*A BankAccount cannot exist unless it is owned 
	 * by a BankCustomer */
	public Account(Customer holder) {
	/*The class allocates NEXTNUMBER as this object’s 
	 * accountNumber. The class then increments NEXTNUMBER 
	 * by 1, ensuring that the next object it creates gets 
	 * a different account number */
		this.nbr = NEXTNUMBER++;
		this.holder = holder;
		 balance = 0;
	}
	 
	public void setNbr(int nbr) {
		this.nbr = nbr;
	}
	public int getNbr() {
		return nbr;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getBalance() {
		return balance;
	}
	public void setHolder(Customer value) {
		this.holder = value;
	}
	public Customer getHolder() {
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
	public boolean canDebit(double anAmount) {
	return anAmount <= balance;
	}

	public Account(int nbr, double balance) {
		this.nbr = nbr;
		this.balance = balance; 
	}

}
