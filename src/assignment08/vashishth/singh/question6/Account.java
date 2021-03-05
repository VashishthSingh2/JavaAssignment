package assignment08.vashishth.singh.question6;

public class Account {
	private double totalBalance;
	public boolean isSufficientBalance(int bal) {
		if(totalBalance>bal){
			return true;
		}
		else {
			return false;
		}
	}
	public void withdrawAmount(int amt) {
		totalBalance-=amt;
		System.out.println("Withdrawn Amount: "+amt);
		System.out.println("Remaining Balance: "+totalBalance);
	}
	public Account() {
		super();
		this.totalBalance = 1000;
	}
	public double getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}
}
