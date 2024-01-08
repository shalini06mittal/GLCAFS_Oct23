package one2one;

import javax.persistence.Embeddable;

// this annotation will not create an email table but will embed its properties in any class that uses it
@Embeddable
public class Email {

	private String studentemail;

	public Email() {
		// TODO Auto-generated constructor stub
	}
	
	public Email(String studentemail) {
		super();
		this.studentemail = studentemail;
	}

	public String getStudentemail() {
		return studentemail;
	}

	public void setStudentemail(String studentemail) {
		this.studentemail = studentemail;
	}
	
	
}
