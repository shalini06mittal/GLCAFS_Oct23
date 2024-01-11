package manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {

	@Id
	private String email;
	private String password;
	private String phone;
	
	@ManyToMany()
	@JoinTable(name="likedbooks", 
	inverseJoinColumns = @JoinColumn(name="bookid"),
	joinColumns  = @JoinColumn(name="useremail"))
	private List<Books> likedbooks;
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public Users(String email, String password, String phone) {
		super();
		this.email = email;
		this.password = password;
		this.phone = phone;
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
	public List<Books> getLikedbooks() {
		return likedbooks;
	}
	public void setLikedbooks(List<Books> likedbooks) {
		this.likedbooks = likedbooks;
	}
	@Override
	public String toString() {
		return "Users [email=" + email + ", password=" + password + ", phone=" + phone + "]";
	}
	
	
	
}
