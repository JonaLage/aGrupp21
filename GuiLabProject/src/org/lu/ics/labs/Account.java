package org.lu.ics.labs;

public class Account {

	//private int cardNumber;
	private int nbr;
	//private String type;
	private double balance;
	
	private Customer holder;
	
	/*public int getCardNumber() {
		return this.cardNumber;
	}
	
	public void setCardNumber(int value) {
		this.cardNumber = value;
	}
	
	public String getType() {
		return  this.type;
	}
	
	public void setType(String type) {
		this.type  = type;
	}
	
	public Customer getHolder() {
		return this.holder;
	}
	
	public void setHolder(Customer value) {
		this.holder = value; 
	}
	public Creditcard(int cNbr, String type) {
		this.setCardNumber(cNbr);
		this.setType(type);
	}
	*/
	
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
	public void credit(double amountIn) {
		balance += amountIn;
	}
	public void withdraw(double amountOut) {
		balance -= amountOut;
	}
	public Account(int nbr, double balance) {
		this.nbr = nbr;
		this.balance = balance; 
	}
	
}
