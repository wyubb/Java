package banking5;

import banking5.Account;

public class Customer {
	private String firstName;
	private String lastName;
	private Account account;
	
	public Customer(String f,String l) {
		firstName = f;
		lastName = l;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account acct) {
		account = acct;
	}
}
