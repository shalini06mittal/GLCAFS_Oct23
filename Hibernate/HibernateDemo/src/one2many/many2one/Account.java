package one2many.many2one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	@Id
	private String accountid;
	private double balance;
	private String acctype;
	@ManyToOne()//(cascade = CascadeType.ALL)
	@JoinColumn(name="email")
	private Customer customer;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String accountid, double balance, String acctype) {
		super();
		this.accountid = accountid;
		this.balance = balance;
		this.acctype = acctype;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", balance=" + balance + ", acctype=" + acctype + "]";
	}
	
}
