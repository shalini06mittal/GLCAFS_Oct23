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

		Address a1 = new Address("Delhi", "India");
		
		Email e1 = new Email();
		e1.setStudentemail("ranjitha@gmail.com");
		
		Student s1 = new Student("Ranjitha", e1, a1);
		
		//TransientObjectException: object references an unsaved transient instance - 
		//save the transient instance before flushing: one2one.Address
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//session.save(a1);// serialization
		session.save(s1);
		tx.commit();
		session.close();		
				
//		Address a2 = new Address("Pune", "India");
//		System.out.println(a2.getAddressid());
		
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(a2);// serialization
//		tx.commit();
//		session.close();
				
		
//		Student s2 = new Student();
//		s2.setEmail(new Email("sia@gl.com"));
//		s2.setSname("Sia");
//		s2.setAddress(a2);
//		
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(s2);// serialization
//		tx.commit();
//		session.close();
			
		/**
		 * One to one => eager fetching
		 * student, address
		 * Get details of the student with id as 1
		 * By default hibernate performs join between student and address and fetches all the data
		 */
//		Session session = sessionFactory.openSession();
//		Student s = session.get(Student.class, 1);
//		session.close();
//		//System.out.println(s);
//		System.out.println(s.getSname()+" "+s.getEmail().getStudentemail());//+" "+s.getAddress().getCity());
//		System.out.println(s.getAddr().getAddressid()+" "+s.getAddr().getCity());
//		System.out.println(s.getLibraryCard().getId());//+" "+s.getLibraryCard().isActive());
//		session = sessionFactory.openSession();
//		LibraryCard ob =  session.get(LibraryCard.class, s.getLibraryCard().getId());// ob.id = 2
//		session.close();
//		System.out.println(ob.getStudent().getSname());
		
		
	}
	

}
