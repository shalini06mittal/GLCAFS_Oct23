package database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Blog;
import util.HibernateUtil;

public class BlogDatabase {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public List<Blog> getAllBlogs(){
		Session session = sessionFactory.openSession();
		List<Blog> list = session.createQuery("from Blog").list();
		session.close();
		return list;
	}
	public List<Blog> getAllBlogsByEmail(String email){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Blog b where b.createdBy.email=:email");
		query.setString("email", email);
		List<Blog> blogs = query.list();
		session.close();
		return blogs;
	}
	public Blog editBlog( Blog blog) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(blog);
		Blog updatedBlog = session.get(Blog.class, blog.getBlogid());
		tx.commit();
		session.close();
		return updatedBlog;
	}
	public Blog addBlog( Blog blog) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(blog);
		Blog newBlog = session.get(Blog.class, blog.getBlogid());
		tx.commit();
		session.close();
		return newBlog;
	}
	public boolean deleteBlog( Blog blog) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(blog);
		tx.commit();
		session.close();
		return true;
	}
	
	public Blog getBlogById( int id) {
		Session session = sessionFactory.openSession();
		Blog blog = session.get(Blog.class, id);
		session.close();
		return blog;
	}
	
}

