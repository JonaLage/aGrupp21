package application;

import java.util.ArrayList;
import java.util.Collection;

import org.lu.ics.labs.Account;
import org.lu.ics.labs.Person;
import org.lu.ics.labs.PersonRegister;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

	@FXML
	private TextField txtPersonName;
	@FXML
	private TextField txtPersonNbr;
	@FXML
	private TextField txtAccountNbr;
	@FXML
	private TextField txtCredit;
	@FXML
	private TextField txtWithdraw;
	@FXML
	private TextField txtBalance;
	@FXML
	private Label lblResponse;
	@FXML
	private TextArea taComment;
	@FXML
	private Button btnAddPerson_Click;

	PersonRegister reg = new PersonRegister();
	ArrayList<Account> accounts = new ArrayList<Account>();

	@FXML
	public void btnAddAccount_Click(ActionEvent event) {
		/*
		 * För att vi ska kunna "add account" så ska vi ha in pNbr och aNbr. Namn är ej
		 * nödvändigt (vilket kan leda tll lite problem när vi printar text. Metoden
		 * letar först efter person i personregister utifrån pNbr. Ett nytt account
		 * skapas och kopplas till person p. Om pNbr inte har lagts till i vårt register
		 * skrivs felmeddelande ut.
		 */
		String name = txtPersonName.getText();
		String pNbr = txtPersonNbr.getText();
		String aNbr = txtAccountNbr.getText();
		try {
			Person p = reg.findPerson(pNbr);
			Account a = new Account(aNbr);
			p.addAccount(a);
			lblResponse.setText("Response:");
			taComment.setText("Account " + aNbr + " added to " + name + ".");
		} catch (Exception e) {
			lblResponse.setText("Response:");
			taComment.setText("Response: No person with personal number " + pNbr + " in our register."
					+ " Please add new customer.");
		}
	}

	@FXML
	public void btnFindPerson_Click(ActionEvent event) {
		/*
		 * För att hitta person ska vi ha in pNbr. Vi söker sedan efter pNbr i
		 * personregister. If personen finns: Skriv ut namn och accounts. If personen
		 * har accounts, skriv ut accounts. Else om kund ej har skrivit in pNbr i
		 * textrutan så får den upp felmeddelande: please enter... Else om kund ej finns
		 * i registret så får den upp felmeddelande: customer does not...
		 */
		String pNbr = txtPersonNbr.getText();
		Person p = reg.findPerson(pNbr);
		if (p != null) {
			lblResponse.setText("Response:");
			taComment.setText("Customer name: " + p.getName() + "\nAccounts: " + p.getAccounts());
			if (p.getAccounts() != null) {
				accounts = p.getAccounts();
			}
		} else {
			if (txtPersonNbr.getText().isEmpty()) {
				lblResponse.setText("Response:");
				taComment.setText("Please enter personal number.");
			} else {
				lblResponse.setText("Response:");
				taComment.setText("Customer does not exist.");
			}
		}

	}

	@FXML
	// FUNKAR
	public void btnDeletePerson_Click(ActionEvent event) {
		/*
		 * För att radera en person så behöver vi få in pNbr. If täxtfältet är tomt får
		 * kunden upp felmeddelande: plese enter... Else raderar programmet personen
		 * från registret.
		 */
		String pNbr = txtPersonNbr.getText();
		if (txtPersonNbr.getText().isEmpty()) {
			lblResponse.setText("Response:");
			taComment.setText("Please Enter Customer ID to delete.");
		} else {
			lblResponse.setText("Response:");
			reg.removePerson(pNbr);
			taComment.setText("Customer " + pNbr + " has been deleted.");
		}
	}

	@FXML
	public void btnAddPerson_Click(ActionEvent event) {
		/*
		 * För att lägga till en person behöver vi namn och personnummber. En ny person
		 * skapas och läggs till i registret.
		 */
		String name = txtPersonName.getText();
		String pNbr = txtPersonNbr.getText();
		Person p = new Person(pNbr, name);
		reg.addPerson(p);
		lblResponse.setText("Response:");
		taComment.setText(name + " with personal number " + pNbr + " has been added to the register.");

	}

	@FXML
	public void btnCredit_Click(ActionEvent event) {
		/*
		 * För att kunna göra insättning behöver vi pNbr och aNbr. Vi letar fram det
		 * account som har skapats med samma pNbr och aNbr och lägger till den summan
		 * som har skrivit in i textfältet. Förbättringsmöjlighet: att lägga en limt på
		 * hur mycket man får sätta in.
		 */
		String pNbr = txtPersonNbr.getText();
		String aNbr = txtAccountNbr.getText();
		double credit = Double.parseDouble(txtCredit.getText());
		Account a = reg.findAccount(pNbr, aNbr);
		a.credit(credit);
		lblResponse.setText("Response:");
		taComment.setText("Added " + credit + " kr to " + aNbr);

	}

	@FXML
	public void btnWithdraw_Click(ActionEvent event) {
		/*
		 * Samma som insättning. Om debit <= balance så kan uttag genomföras. Om debit
		 * >= balance så får kunden upp insufficient amount.
		 */
		String pNbr = txtPersonNbr.getText();
		String aNbr = txtAccountNbr.getText();
		double debit = Double.parseDouble(txtWithdraw.getText());
		Account a = reg.findAccount(pNbr, aNbr);
		if (a.canDebit(debit) == true) {
			a.debit(debit);
			lblResponse.setText("Response:");
			taComment.setText("Withdrew " + debit + " kr from " + aNbr);
		} else {
			lblResponse.setText("Response:");
			taComment.setText("Insufficient amount.");
		}
	}

	@FXML
	public void btnBalance_Click(ActionEvent event) {
		/*
		 * Behöver pNbr för att kolla balans. Letar fram person ur registret och tar
		 * fram den total balansen för personen.
		 */
		double balance;
		String pNbr = txtPersonNbr.getText();
		Person p = reg.findPerson(pNbr);
		balance = p.totalBalance();
		lblResponse.setText("Response:");
		taComment.setText("Your balance is " + balance + " kr.");
	}

	@FXML
	public void btnViewAccounts_Click(ActionEvent event) {
		/*
		 * För att view account måste vi pNbr. Letar fram person ur registret och tar
		 * fram personens accounts och lägger den i listan accounts. Ska sedan skriva ut
		 * alla accounts men gör det inte utan skriver bara ut den senaste. Får den ej
		 * att funka. Förbättringsmöjlighet: Ifall kunden ej har accounts så ska
		 * felmeddelande skrivas ut. Har testat men blev död kod.
		 */
		String pNbr = txtPersonNbr.getText();
		Person p = reg.findPerson(pNbr);
		accounts = p.getAccounts();
		lblResponse.setText("Response:");
		taComment.setText("All accounts under customer id: " + pNbr);
		for (Account tmp : accounts)
			taComment.setText("Account: " + tmp);
	}
}
