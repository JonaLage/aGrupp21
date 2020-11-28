package org.lu.ics.labs;

public class Customer {
	private String cNumber; 
	private String cName;
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
	public Customer(String cNumber, String cName) { 
		this.setCNumber(cNumber); 
		this.setCName(cName);
	}
}
