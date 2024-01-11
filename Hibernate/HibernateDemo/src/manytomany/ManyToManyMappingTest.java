package manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ManyToManyMappingTest {

	private static SessionFactory sessionFactory ;
	
	public static void main(String[] args) {

		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();

		Users users1 = new Users("a@a.c", "aa", "1212121212");
		Users users2 = new Users("b@b.c", "bb", "8787878787");
		Users users3 = new Users("c@c.c", "cc", "9999999999");
		
		
//		Session session = sessionFactory.openSession();
//		
//		Transaction tx = session.beginTransaction();
//		Books b1 = session.load(Books.class, 1);
//		Books b2 = session.load(Books.class, 2);
//		Books b3 = session.load(Books.class, 3);
//		Books b4 = session.load(Books.class, 4);
//		
//		users1.setLikedbooks(Arrays.asList(b1,b2));
//		users2.setLikedbooks(Arrays.asList(b3,b4));
//		users3.setLikedbooks(Arrays.asList(b1,b4));
//		
//		session.save(users1);
//		session.save(users2);
//		session.save(users3);
//		tx.commit();
//		
//		session.close();
		List<Books> books = new ArrayList<Books>();
		Session session = sessionFactory.openSession();
		Users ob = session.get(Users.class, "a@a.c");
		
		books = ob.getLikedbooks();
		System.out.println(books.size()); //0
//		System.out.println(ob);
//		for(Books b: books) {
//			System.out.println(b);
//		}
		session.close();
		
		
		
		
		
	}
	

}
