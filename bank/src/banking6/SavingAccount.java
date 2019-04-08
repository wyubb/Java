package banking6;

//´¢ĞîÕË»§
public class SavingAccount extends Account {
				 
			
	private double interestRate;
					 
	public SavingAccount(double balance,double interest_rate) {
			super(balance);
			this.interestRate = interest_rate;
	}
	public double getInterestRate() {
		return interestRate;
	}
			
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
