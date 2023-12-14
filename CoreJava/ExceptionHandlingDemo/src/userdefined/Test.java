package userdefined;

public class Test {

	public static void main(String[] args) {
		
		Account a1 = new Account();
		a1.setAccno(1);
		a1.setBalance(5000);
		
		try {
			System.out.println(a1.withdraw(2000));
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println(a1.withdraw(4000));
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("main ends");
	}

}
