package org.lu.ics.labs;

public class Creditcard {

	private String cNumber;
	private String cName;
	
	public Creditcard(String cNumber, String cName) {
		this.cNumber = cNumber;
		this.cName = cName;
	}

	private Creditcard creditcard;

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

	public Creditcard getCreditcard() {
		return this.creditcard;
	}

	public void setCreditcard(Creditcard value) {
		this.creditcard = value;
	}

	public void addCreditcard(Creditcard card) {
		this.setCreditcard(card);
	}

	public void setHolder(Customer tmpCustomer) {
		// TODO Auto-generated method stub
		
	}

	public Creditcard getHolder() {
		// TODO Auto-generated method stub
		return null;
	}

}
