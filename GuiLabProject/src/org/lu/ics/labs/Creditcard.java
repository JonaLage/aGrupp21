package org.lu.ics.labs;

public class Creditcard {

	private int cardNumber;
	private String type;
	
	private Customer holder;
	
	public int getCardNumber() {
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
}
