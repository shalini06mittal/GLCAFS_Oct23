package database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import dto.BloggersDTO;
import entity.Bloggers;
import util.HibernateUtil;
//https://www.dineshonjava.com/hibernate/understanding-restrictions/
public class UserDatabase {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public boolean insertBlogger(Bloggers bloggers)
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(bloggers);
		tx.commit();
		return true;
	}
	public boolean emailExists(String email) {
		Session session = sessionFactory.openSession();
		boolean exists = session.createCriteria(Bloggers.class)
        .add(Restrictions.eq("email", email))
        .setProjection(Projections.property("email"))
        .uniqueResult() != null;
		return exists;
	}
	public String getCredentials(String email, String password)
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Bloggers.class)
				.add( Restrictions.eq("email", email))
				.setProjection(Projections.projectionList()
						.add(Projections.property("password")));
		List credentials = criteria.list();
		session.close();
		if(credentials.size() == 0)
			return null;
		return (String)credentials.get(0);
	}
	public Bloggers getBloggerProfile(String email) {
		Session session = sessionFactory.openSession();
		Bloggers bloggers = session.get(Bloggers.class, email);
		session.close();
		return bloggers;
	}
}
