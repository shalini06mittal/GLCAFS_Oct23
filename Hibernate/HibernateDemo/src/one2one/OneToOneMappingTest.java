package one2one;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class OneToOneMappingTest {

	private static SessionFactory sessionFactory ;
	
	public static void main(String[] args) {

		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();

		Address a1 = new Address("Pune", "India");
		
		Email e1 = new Email();
		e1.setStudentemail("riya@gmail.com");
		
		Student s1 = new Student("Riya", e1, a1);
		
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(a1);// serialization
//		session.save(s1);
//		tx.commit();
//		session.close();		
				
		Address a2 = new Address("Pune", "India");
		System.out.println(a2.getAddressid());
		
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(a2);// serialization
//		tx.commit();
//		session.close();
				
		
		Student s2 = new Student();
		s2.setEmail(new Email("sia@gl.com"));
		s2.setSname("Sia");
		s2.setAddress(a2);
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(s2);// serialization
		tx.commit();
		session.close();
			
		
				
		
//		Address a3 = new Address("Mumbai", "India");
//		Address a4 = new Address("New York", "USA");
		
		
	}
	

}
