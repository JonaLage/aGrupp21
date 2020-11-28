package org.lu.ics.labs;

public class Test {

	public static void main(String[] args) {
		//Skapar två nya kreditkort
		Creditcard creditCard1 = new Creditcard("123", "Visa");
		Creditcard creditCard2 = new Creditcard("234", "Mastercard");
		
		//Skapar två nya kunder
		Customer customer1 = new Customer("1111-1111", "Anna Andersson");
		Customer customer2 = new Customer("2222-2222", "Beata Bengtsson");
		
		//Skapar ett nytt kundregister
		CustomerRegister customers = new CustomerRegister();
		
		//Kopplar kort till kund
		creditCard1.setHolder(customer1);
		creditCard2.setHolder(customer2);
		
		//Koppar kund till kort
		customer1.setCreditcard(creditCard1);
		customer2.setCreditcard(creditCard2);
		
		//Lägger in kunderna i ArrayList
		customers.addCustomer(customer1);
		customers.addCustomer(customer2);
		
		//Testar några av objektens metoder
		System.out.println(creditCard1.getHolder().getCName());
		System.out.println(customer2.getCreditcard().getCNumber());
		Customer tmpC = customers.findCustomer("1111-1111");
		if(tmpC != null) {
			System.out.println("Hittade: " + tmpC.getCName());
		}
		customers.removeCustomer("1111-1111");
		Customer tmpCustomer = customers.findCustomer("1111-1111");
		if(tmpCustomer  == null) {
			System.out.println("Fungerar!");
		}
	}
}
