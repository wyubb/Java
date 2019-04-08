package banking5_2;

public class Customer {
	private String firstName;
	private String lastName;
	//private Account account;
	
	private SavingAccount savingAccount ;
	private CheckingAccount checkingAccount ;
	
	public Customer(String f,String l) {
		firstName = f;
		lastName = l;
			
	}
	
	
	
	public SavingAccount getSaving() {
		return savingAccount;
	}



	public CheckingAccount getChecking() {
		return checkingAccount;
	}



	public void setSaving(SavingAccount savingAccount) {
		this.savingAccount = savingAccount;
	}

	public void setChecking(CheckingAccount checkingAccount) {
		this.checkingAccount = checkingAccount;
	}

//	public void addAccount(Account acc) {
//		
//		accounts[numOfAccounts] = acc;
//		numOfAccounts++;
//	}
//	
//	public Account getAccount(int index) {
//		return accounts[index];
//		
//	}
//	
//	public int getNumOfAccounts() {
//		return numOfAccounts;
//	}
//	
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
