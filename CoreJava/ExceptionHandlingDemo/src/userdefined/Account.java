package userdefined;

public class Account {

	private int accno;
	private double balance; // 10000
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double withdraw(double amount) throws InsufficientBalanceException { // 12000
		if(amount >= balance)
			throw new InsufficientBalanceException("Cannot withdraw");
		balance = balance - amount;
		return balance;
	}
}
