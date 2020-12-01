package org.lu.ics.labs;

import java.util.ArrayList;

public class PersonRegister {
	private ArrayList<Person> personRegister = new ArrayList<Person>();
	private Person person;

	public ArrayList<Person> getPersonRegister() {
		return personRegister;
	}

	public void setPersonRegister(ArrayList<Person> personRegister) {
		this.personRegister = personRegister;
	}
	public Person getPerson() {
		return person;
	}

	public void addPerson(Person p) {
		this.personRegister.add(p);
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}

	public Person findPerson(String pNbr) {
		for (Person p : personRegister) {
			if (p.getpNbr().equals(pNbr)) {
				return p;
			}
		}
		return null;
	}

	public Person removePerson(String pNbr) {
		Person p = findPerson(pNbr);
		if (p != null) {
			personRegister.remove(p);
		}
		return p;

	}

	public Account findAccount(String pNbr, String accountNbr) {
		Person p = findPerson(pNbr);
		if (p != null) {
			Account tmp = p.findAccount(accountNbr);
			if (tmp != null) {
			return tmp;
			}
		}
		return null;
	}

	public Double totBalancePerson(String pNbr) {
		double totBalance = 0;
		for (Person tmp : personRegister) {
			if (tmp.getpNbr().equals(pNbr)) {
				totBalance = tmp.totalBalance();
				return totBalance;
			}
		}
		return null;
	}
	public void setPersonName(String pNbr, String newName) {
		Person p = this.findPerson(pNbr);
		if (p != null) {
			p.setName(newName);
		}
	}

}

