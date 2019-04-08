package banking5_1;

public class Customer {
	private String firstName;
	private String lastName;
	//private Account account;
	private Account[] accounts;
	private int numOfAccounts;
	
	public Customer(String f,String l) {
		firstName = f;
		lastName = l;
		accounts = new Account[5];
		
	}
	
	
	
	public void addAccount(Account acc) {
		
		accounts[numOfAccounts] = acc;
		numOfAccounts++;
	}
	
	public Account getAccount(int index) {
		return accounts[index];
		
	}
	
	public int getNumOfAccounts() {
		return numOfAccounts;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
//	public Account getAccount() {
//		return account;
//	}
//	
//	public void setAccount(Account acct) {
//		account = acct;
//	}
}
