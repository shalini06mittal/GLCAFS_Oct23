package one2many.many2one;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	private String email;
	
	@ElementCollection//(fetch = FetchType.EAGER)
	@JoinTable(name = "phone", 
	joinColumns = @JoinColumn(name="email"))
	@Column(name = "phone_no")
	private List<String> phone;
	
	private String fullname;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)// fetch = FetchType.EAGER)
	private List<Account> account;
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String email, List<String> phone, String fullname) {
		super();
		this.email = email;
		this.phone = phone;
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhone() {
		return phone;
	}

	public void setPhone(List<String> phone) {
		this.phone = phone;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	
	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email +  ", fullname=" + fullname 
				+ "]";
	}
		
}
