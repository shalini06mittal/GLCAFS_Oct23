package entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="blog")
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blogid;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false, length = 1000)
	private String content;
	
	private String imagelink;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	//@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@OneToOne
	@JoinColumn(name="categoryid")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="email",nullable = false)
	private Bloggers createdBy;
	
	public Blog() {
		// TODO Auto-generated constructor stub
	}

	public Blog(String title, String content, Category category, Bloggers createdBy) {
		super();
		this.title = title;
		this.content = content;
		this.category = category;
		this.createdBy = createdBy;
	}

	public int getBlogid() {
		return blogid;
	}

	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Bloggers getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Bloggers createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "Blog [blogid=" + blogid + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
	
	
}
