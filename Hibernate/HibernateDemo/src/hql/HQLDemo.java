package hql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import manytomany.Books;

public class HQLDemo {

	private static SessionFactory sessionFactory ;
	
	public static void main(String[] args) {
		/**
		 * select
		 * from
		 * where
		 * order by
		 * group by
		 * having
		 * joins
		 * 
		 * HQl API
		 * 1. Query q: Get the reference of type Query use createQuery(<hql>)
		 * HQL : working with java classes and properties
		 * select
		 * from
		 * where
		 * all operators : logical, equality , comparison
		 * order by
		 * group by
		 * having
		 * 
		 * 
		 * 2. Pagination:
		 * q.setFirstResult()
		 * q.setMaxResults()
		 * 
		 * 3. Named parameters
		 * select * from books where bookid=?
		 * select * from books where bookid=:bookid
		 * 
		 * 4. aggregate funciton :
		 * select sum()
		 * 
		 * 5. projection : specify the column names
		 * 
		 * Criteria API
		 * Criteria
		 * Criterion
		 * Restrictions
		 * 
		 */

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		getMoreThan1ColumnsFromBooks();
	}
	
	public static void getBooksBetweenYear()
	{
		Session session= sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Books.class);
		
		Criterion cr = Restrictions.between("year", 1900, 1950);
		
		criteria.add(cr);
		
		List<Books> list = criteria.list();
		
		session.close();
		System.out.println(list.size());
		for(Books b:list)
			System.out.println(b);
	}
	public static void getBooksByYear()
	{
		Session session= sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Books.class);
		
		Criterion cr = Restrictions.eq("year", 1950);
		
		
		criteria.add(cr);
		
		List<Books> list = criteria.list();
		
		session.close();
		System.out.println(list.size());
		for(Books b:list)
			System.out.println(b);
	}
	public static void getBooksByPriceGreaterThanAndOrderBy()
	{
		Session session= sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Books.class);
		
		Criterion cr = Restrictions.gt("price", 700);
		criteria.addOrder(Order.asc("price"));
		
		criteria.add(cr);
		
		List<Books> list = criteria.list();
		
		session.close();
		System.out.println(list.size());
		for(Books b:list)
			System.out.println(b);
	}
	
	public static void getSpecificColumnsFromBooks()
	{
		Session session= sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Books.class);
		
		criteria.setProjection(Projections.property("title"));
		
		criteria.setMaxResults(10);
		List<String> list = criteria.list();
		
		session.close();
		System.out.println(list.size());
		for(String b:list)
			System.out.println(b);
	}
	public static void getMoreThan1ColumnsFromBooks()
	{
		Session session= sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Books.class);
		
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.property("title"));
		pl.add(Projections.property("author"));
		pl.add(Projections.property("price"));
		
		criteria.setProjection(pl);
		criteria.setMaxResults(10);
		List list = criteria.list();
		
		session.close();
		System.out.println(list.size());
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			Object ob[] = (Object[])it.next();
			for (int i = 0; i < ob.length; i++) {
				System.out.print(ob[i]+" : ");
			}
			System.out.println();
		}
	}
	

}
