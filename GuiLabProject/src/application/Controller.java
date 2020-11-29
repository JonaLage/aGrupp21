package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.lu.ics.labs.Account;
//import org.lu.ics.labs.Creditcard; 
import org.lu.ics.labs.Customer;
import org.lu.ics.labs.CustomerRegister;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label; 
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	
	@FXML
	private TextField txtCustName;
	@FXML
	private TextField txtCustNbr;
	@FXML
	private TextField txtAccountType;
	@FXML
	private TextField txtAccountNbr;
	@FXML
	private Label lblResponse;
	@FXML
	private TextArea taComment;
	@FXML
	private RadioButton rbtnHasCard;
	@FXML
	private RadioButton rbtnNoCard;
	
	public ArrayList<Customer> customers = new ArrayList<Customer>();
	public ArrayList<Account> accountList = new ArrayList<Account>();
	CustomerRegister cReg = new CustomerRegister(); ////Kan hålla lista av customer


	
	
	@FXML
	public void btnAdd_Click(ActionEvent event) {
	String cName = txtCustName.getText();
	String cNumber = txtCustNbr.getText();
	Customer tmpCustomer = new Customer(cNumber, cName);
	lblResponse.setText("Response: New customer created.");
	if (rbtnHasCard.isSelected()) {
		String AccountType = txtAccountType.getText();
		int nbr;
		try {
			nbr = Integer.parseInt(txtAccountNbr.getText());
			Account a = new Account(nbr, AccountType);
			tmpCustomer.setAccountList(accountList);
			a.setHolder(tmpCustomer);
		} catch (Exception e1) {
			lblResponse.setText("Response: Error, Account Number.");
		}
	} else {
		lblResponse.setText("Response: blablabla");
	}
	cReg.addCustomer(tmpCustomer);
	}
	
		/*För att skapa ett konto:
    - If kunden ej finns måste kunden först registrera sig. Dvs skapa ett “new name”. Meddela “Customer not found. Create new. “
    - Else if kund finns:
        - Generera ett unikt account number. 
            -  If “has account” är valt: 
                - Hitta kundens accountList 
                - Lägg till nytt konto 
                - Meddela kund “New account has been added to customer…”
			else:
                - Skapa en ny accountList 
                - Lägg till nytt konto
                - Meddela kund “New account has been created”. */
		
	/*String cNumber = txtCustNbr.getText();
		Customer tmpCustomer = reg.findCustomer(cNumber);  
		if (txtCustNbr.getText().isEmpty()) {
			lblResponse.setText("Please Enter Personal Number.");
			// return 0;
		} else { // since no errors were detected. create new account.
			//generate unique account number
			Random rnd = new Random();
			//0 to 8
			int n1 = rnd.nextInt(9);
			lblResponse.setText("Generated accountnumber is: ");

			if(rbtnHasCard.isSelected()) {
				accountList.add(rnd);
				}
			}
		}
                
     
	
	/*public void btnAddAccount_Click(ActionEvent event) {
		boolean isAcctFound = false;
		/*
		// user enters 0 in the account number then generate an account number
		if (txtCardNbr.getText().equals("0")) {
			txtCardNbr.setText(autoAcctNum + bu.generateUniqueAccountNumber());
		// did the user enter anything
		} else if (txtCardNbr.getText().isEmpty()){
			lblResponse.setText("Account Number cannot be blank!\nPlease enter Account Number or press 0 to automaticlly generate one!");
			
		} else {
			// check to see if the entered account already exists
			for (Account a: accountList) {
				if (a.getNbr().equals(txtCardNbr.getText())) {
					isAcctFound = true;
				}
			}
			// notify user account already exists
			if (isAcctFound) {
				lblResponse.setText("Account Number already used! Please choose a different Account Number!");
				
			// notify user the account number can be used
			} else {
				lblResponse.setText("Account Number accepted!");
			}
		}*/
		/*if (txtAccountNbr.getText().equals("0")) {
			txtAccountNbr.setText(autoAcctNum + bu.generateUniqueAccountNumber());
		} else if (txtAccountNbr.getText().isEmpty()) {
			lblResponse.setText("Account Number cannot be blank!\nPlease enter Account Number or press 0 to automaticlly generate one!");
		} else {
			for (Account a: accounts) {
				if (a.getAccountNumber().equals(txtAccountNbr.getText())) {
					isAcctFound = true;
				}
			}
			if (isAcctFound) {
				lblResponse.setText("Account Number already used! Please choose a different Account Number!");
				
			} else {
				lblResponse.setText("Account Number accepted!");
			}
		}
	}*/
	
	@FXML
	public void btnFind_Click(ActionEvent event) {
		String cNumber = txtCustNbr.getText();
		Customer tmpCustomer = cReg.findCustomer(cNumber); 
		while(txtCustNbr.getText().isEmpty()) {
		lblResponse.setText("Please enter personal number");
		}
		if (cNumber != null){
			for (Customer c : customers) {
				taComment.setText("Customer name: " +c.getCName()+ "\nAccounts: "+c.getAccountList());
			}
		} else if (!cNumber.equals(tmpCustomer.getCNumber())) {
				lblResponse.setText("Customer does not exist.");
		}
			
	}
	
	

		/*String cNumber = txtCustNbr.getText();
		Customer tmpCustomer = reg.findCustomer(cNumber);
		if (txtCustNbr.getText().isEmpty()) {
			lblResponse.setText("Please enter personal number");
		} else if
		getAccountList

			
			lblResponse.setText("Response: hej hej");
			txtCustNbr.setText(tmpCustomer.getCNumber());
			txtCustName.setText(tmpCustomer.getCName());
				if (tmpCustomer.getAccountList() != null) {
					ArrayList<Account> acc = tmpCustomer.getAccountList();
					//txtAccountNbr.setText(Integer.toString(acc.get()));
				rbtnHasCard.setSelected(true);
			} else {
				txtAccountType.setText("");
				txtAccountNbr.setText("");
				rbtnNoCard.setSelected(true);
			}
		} else {
			lblResponse.setText("Response: Customer not found");
			}
			
			}*/


	@FXML
	public void btnDelete_Click(ActionEvent event) {
		
		String cNumber = txtCustNbr.getText();
		if (txtCustNbr.getText().isEmpty()) {
			lblResponse.setText("Please Enter Customer ID to delete.");
		}  else {
		cReg.removeCustomer(cNumber);
		lblResponse.setText("Response: Customer " +txtCustNbr.getText()+ " deleted.");
		}
	}
		
		/*String description = "";
		// user is removing a customer
		if (remNum==0) { // remove customer
			// validate customer
			for (Customer c: customers) {
				if (c.getCustomerID().equals(txtCustomerNum.getText())) {
					if (!c.getActive()) {
						// set the description with customer id and name
						description = c.getCustomerID() + "\t" + c.getCustomerName() + " Removed";
						// make transaction
						createCustomerTransaction(c.getCustomerID(), description);
						// remove customer
						customers.remove(c);
						// notify user
						lblMessage.setText(description);
						break;
					}
				}		
		
	}*/

	@FXML
	public void btnNewName_Click(ActionEvent event) {
		// what is the current size of the customer table (array list)
		// this will be used to determine if the customer was added successfully
		int element = customers.size();
		String cNumber = txtCustNbr.getText();
		Customer tmpCustomer = cReg.findCustomer(cNumber);
		
		// did the user enter any information in the ID box
		if (txtCustNbr.getText().isEmpty()) {
			lblResponse.setText("Please Enter Customer ID");
			// return 0;
		} else if (txtCustName.getText().isEmpty()) { // did the user enter any information in the Name box
			lblResponse.setText("Please Enter Customer Name");
			// return 1;
		} else { // since there were no errors that I detected, add the customer to the table
			for (Customer c : customers) {
				if (c.getCNumber().equals(txtCustNbr.getText())) {
					lblResponse.setText("Customer ID already Exists!");
				}
			}
			Customer customer = new Customer(txtCustNbr.getText(), txtCustName.getText());
			customers.add(customer);
			String newName = txtCustName.getText();
			cReg.setCustomerName(cNumber, newName);
			// check to see if the customer was added to the table and return true if yes
			// and false if not
			if (element < customers.size()) {
				lblResponse.setText("Customer Created successfully!");
			} else { // notify the user that the customer was not added
				if (element == customers.size()) {
					lblResponse.setText("Customer Creation unsuccessful!");
				}
			}
		}
	}
	
		/*String cNumber = txtCustNbr.getText();
		Customer tmpCustomer = reg.findCustomer(cNumber);
		/*if (tmpCustomer != null) {
			lblResponse.setText("Response: New customer created.");
			String newName = txtCustName.getText();
			reg.setCustomerName(cNumber, newName);
		} else {
			lblResponse.setText("Response: New customer could not be created.");
		}
		
		
		@FXML
		*/public void btnCredit_Click(ActionEvent event) {
			
	

	
}
}


