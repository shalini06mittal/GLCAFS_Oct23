package one2one;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "library_card")
public class LibraryCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private boolean isActive;
	private LocalDate issueDate;
	
	public LibraryCard() {
		// TODO Auto-generated constructor stub
	}

	public LibraryCard(boolean isActive, LocalDate issueDate) {
		super();
		this.isActive = isActive;
		this.issueDate = issueDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	@Override
	public String toString() {
		return "LibraryCard [id=" + id + ", isActive=" + isActive + ", issueDate=" + issueDate + "]";
	}
	
}
