package database;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

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
	public Object[] getCredentials(String email, String password)
	{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Bloggers.class)
				.add(Restrictions.and(Restrictions.eq("email", email), Restrictions.eq("password", password)))
				.setProjection(Projections.projectionList().add(Projections.property("email"))
						.add(Projections.property("password")));
		
		Object[] credentials = (Object[])criteria.list().get(0);
		//System.out.println(credentials[0]+" "+ credentials[1]);
		session.close();
		return credentials;
	}
}
