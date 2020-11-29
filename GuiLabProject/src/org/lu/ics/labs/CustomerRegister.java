package org.lu.ics.labs;

import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.text.html.HTMLDocument.Iterator;


public class CustomerRegister {
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	private ArrayList<Account>accounts = new ArrayList();
	

	public ArrayList<Customer> getCustomers() { 
		return this.customers;
	}
	public void setCustomers(ArrayList<Customer> value) { 
		this.customers = value;
	}
	public void addCustomer(Customer newCustomer) { 
		this.customers.add(newCustomer);
	}
	public void removeCustomer(String cNumber) { 
		Customer c = this.findCustomer(cNumber); 
			if (c != null) {
				this.customers.remove(c); 
				}
	}
	public Customer findCustomer(String cNumber) { 
		for (Customer c : this.customers) {
			if (c.getCNumber().equals(cNumber)) { 
				return c;
			} 
		}
		return null; 
	}
	public void setCustomerName(String cNumber, String newName) {
		Customer c = this.findCustomer(cNumber);
		if (c != null) {
			c.setCName(newName); 
		}
	}
	public void addAccount(String customerNbr, Account account) { 
		Customer c = this.findCustomer(customerNbr);
		if (c != null) {
			c.addAccount(account); 
		}
	}
	public Account findAccount(String cNumber, int accountNumber) {
		Customer c = findCustomer(cNumber);
		if (c != null) {
			Account acc = c.findAccount(accountNumber);
			return acc;
		}
		return null;
	}
	public double totBalancePerson(String cNumber) {
		double totb = 0;
		Customer c = findCustomer(cNumber);
		if (c != null) {
			totb = c.totBalance();
		}
		return totb;
	}
	/*credit an existing account in the collection of
	 *account. If nbr isn't found,an error message is returned.
	 *if it is found then it will be credited and a message
	 *is returned to indicate a succesfull credit
	 */
	public String creditAccount(int nbr, double amountIn){
		boolean found = false;
		String results ="";
		ListIterator iter = accounts.listIterator();
		while(iter.hasNext()&& !found)
		        {
		Account acc = (Account)iter.next();       
		if(acc.getNbr()==nbr)
		             {
		              results = acc.credit(amountIn);
			  	found = true; // stop the loop
			     }
			}
		if(!found) results = "Customer not found";
		return results;
		}
	/*Debit an existig account in the collection of accounts
	 *If the account nbr is not found, error message is
	 *returned. If it is found then if the specified amount
	 *is <= balance, it will be debited the amount  and a 
	 *message returned to indicate a successful debit, 
	 *otherwise and error message indicating insufficient
	 *funds is returned. 
	 */
	public String debitAccount(int nbr, double anAmount) {
		boolean found = false;
		String results ="";
		ListIterator iter = accounts.listIterator();
		while(iter.hasNext()&& !found)
		        {
		Account acc = (Account)iter.next();
		   if(acc.getNbr()== nbr)
		             {
		              results = acc.debit(anAmount);
			  	found = true;
			     }
			}

		if(!found) results = "No such customer";
		return results;
		}

}
