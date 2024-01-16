package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import database.BlogDatabase;
import entity.Blog;

public class BlogService {
	
	BlogDatabase blogDatabase;

	public BlogService(BlogDatabase blogDatabase) {
		super();
		this.blogDatabase = blogDatabase;
	}
	
	public List<Blog> getAllBlogs(){
		return blogDatabase.getAllBlogs();
	}
	public List<Blog> getAllBlogsByEmail(String email){
		
		return blogDatabase.getAllBlogsByEmail(email);
	}
	public Blog editBlog( Blog blog) {
		
		return blogDatabase.editBlog(blog);
	}
	public Blog addBlog( Blog blog) {
		
		return blogDatabase.addBlog(blog);
	}
	public boolean deleteBlog( int id) {
		Blog blog = blogDatabase.getBlogById(id);
		return blogDatabase.deleteBlog(blog);
	}
	public Blog getBlogObject( int id) {
		return blogDatabase.getBlogById(id);
	}

}
