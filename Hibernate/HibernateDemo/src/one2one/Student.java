package one2one;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	// auto increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String sname;
	
	@Embedded
	private Email email;
	
	// has - a
	// one student can have only one address
	@OneToOne
	@JoinColumn(name="addrid")
	private Address addr;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String sname, Email email, Address addr) {
		super();
		this.sname = sname;
		this.email = email;
		this.addr = addr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Address getAddress() {
		return addr;
	}

	public void setAddress(Address addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", email=" + email + ", address=" + addr + "]";
	}
	
	
}
