package org.lu.ics.labs;

public class Test {

	public static void main(String[] args) {
		Person p1 = new Person("1", "Lisa");
		Person p2 = new Person("2", "Anna");
		Person p3 = new Person("3", "Emil");
		Account a1 = new Account("11");
		Account a2 = new Account("22");
		Account a3 = new Account("33");
		Account a4 = new Account("44");
		PersonRegister reg = new PersonRegister();

		p1.addAccount(a1);
		p1.addAccount(a2);
		a1.setHolder(p1);
		a2.setHolder(p1);
		p2.addAccount(a3);
		p2.addAccount(a4);
		a3.setHolder(p2);
		a4.setHolder(p2);
		reg.addPerson(p1);
		reg.addPerson(p2);
		reg.addPerson(p3);

		a1.setBalance(500);
		a2.setBalance(1000);
		a3.setBalance(2000);
		a4.setBalance(5000);

		System.out.println("Saldo person 1: ");
		for (Account a : p1.getAccounts()) {
			System.out.println(a.getBalance());
		}
		System.out.println("Saldo person 2: ");
		for (Account a : p2.getAccounts()) {
			System.out.println(a.getBalance());
		}
		System.out.println("Hitta befintliga kunder: ");
		for (Person p : reg.getPersonRegister()) {
			System.out.println(p.getName());
		}
		reg.removePerson("3");
		System.out.println("Hitta befintliga kunder efter borttagning: ");
		for (Person p : reg.getPersonRegister()) {
			System.out.println(p.getName());
		}
		Person p = reg.findPerson("2");
		if (p != null) {
			System.out.println("Hitta person 2: " + p.getName());
		}
		System.out.println("�gare av account 1: " + a1.getHolder().getName());
	}

}
