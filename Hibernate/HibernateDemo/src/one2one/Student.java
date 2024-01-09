package one2one;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	// default one to one does eager fetch 
	@OneToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name="addrid")
	private Address addr;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="libcardid")
	private LibraryCard libraryCard;
	
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

	
	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public LibraryCard getLibraryCard() {
		return libraryCard;
	}

	public void setLibraryCard(LibraryCard libraryCard) {
		this.libraryCard = libraryCard;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", email=" + email + ", addr=" + addr + ", libraryCard="
				+ libraryCard + "]";
	}
	
	
}
