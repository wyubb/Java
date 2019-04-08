package banking5_1;



public class Bank {
	private Customer[] customers;//数组实现存放客户
	private int numberOfCustomers;//记录客户的个数
	
	public Bank() {
		customers = new Customer[5];
		
	}
	
	//添加客户
	public void addCustomer(String f,String l) {
		Customer cust = new Customer(f,l);
		customers[numberOfCustomers] = cust;
		numberOfCustomers++;
	}
	
	//获取客户个数
	public int getNumOfCustomers() {
		return numberOfCustomers;
	}
	
	//返回指定索引的客户
	public Customer getCustomer(int index) {
		
		return customers[index];
			
	}
}
