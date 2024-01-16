package entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * database managed entity to store information about the bloggers
 * @author Shalini
 *
 */

@Entity
@Table(name="bloggers")
public class Bloggers {

	@Id
	private String email;
	@Column(nullable = false)
	private String password;
	private String phone;
	@Column(nullable = false)
	private String firstname;
	private String lastname;
	
	// to store the joinedon as a timestamp with a default value of current time
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDate joinedOn;
	
	@OneToMany(mappedBy = "createdBy")
	private List<Blog> blogs;
	
	public Bloggers() {
		// TODO Auto-generated constructor stub
	}

	public Bloggers(String email, String password, String phone, String firstname, String lastname) {
		super();
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getJoinedOn() {
		return joinedOn;
	}

	public void setJoinedOn(LocalDate joinedOn) {
		this.joinedOn = joinedOn;
	}
	
	
//	@PrePersist
//	protected void onCreate() {
//	    if (joinedOn == null) {
//	        joinedOn = LocalDate.now();
//	    }
//	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	@Override
	public String toString() {
		return "Bloggers [email=" + email + ", password=" + password + ", phone=" + phone + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", joinedOn=" + joinedOn + "]";
	}
	
	
	
}
