package dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import entity.Blog;

public class BloggersDTO {

	private String email;
	private String phone;
	private String firstname;
	private String lastname;
	private LocalDate joinedOn;
	
	public BloggersDTO() {
		// TODO Auto-generated constructor stub
	}

	public BloggersDTO(String email,  String phone, String firstname, String lastname) {
		super();
		this.email = email;
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

	@Override
	public String toString() {
		return "Bloggers [email=" + email + ", phone=" + phone + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", joinedOn=" + joinedOn + "]";
	}
	
	
}
