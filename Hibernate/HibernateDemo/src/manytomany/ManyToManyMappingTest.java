package manytomany;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		//		List<Books> books = new ArrayList<Books>();
		//		Session session = sessionFactory.openSession();
		//		Users ob = session.get(Users.class, "a@a.c");

		//		books = ob.getLikedbooks();
		//		System.out.println(books.size()); //0
		//		System.out.println(ob);
		//		for(Books b: books) {
		//			System.out.println(b);
		//		}
		//		session.close();

		// get all the list of books liked by a particular user
		Session session1 = sessionFactory.openSession();

		/**
		 * select distinct books4_.id as id1_0_, books4_.author as author2_0_, books4_.country as country3_0_, books4_.imageLink as imagelin4_0_, books4_.language as language5_0_, books4_.link as link6_0_, books4_.pages as pages7_0_, books4_.price as price8_0_, books4_.title as title9_0_, books4_.year as year10_0_ 
		 * from users users0_ 
		 * inner join likedbooks likedbooks1_ on users0_.email=likedbooks1_.useremail 
		 * inner join books books2_ on likedbooks1_.bookid=books2_.id 
		 * inner join likedbooks likedbooks3_ on users0_.email=likedbooks3_.useremail 
		 * inner join books books4_ on likedbooks3_.bookid=books4_.id
		 *  where users0_.email='a@a.c'
		 *  
		 *  select books0_.id as id1_0_, books0_.author as author2_0_, books0_.country as country3_0_, books0_.imageLink as imagelin4_0_, books0_.language as language5_0_, books0_.link as link6_0_, books0_.pages as pages7_0_, books0_.price as price8_0_, books0_.title as title9_0_, books0_.year as year10_0_ 
		 *  from books books0_ inner join likedbooks users1_ on books0_.id=users1_.bookid 
		 *  inner join users users2_ on users1_.useremail=users2_.email where users2_.email='a@a.c'
		 */
		List likedbooks = session1
				.createQuery("select  u.title, u.author from Books u join u.users lb where lb.email='a@a.c'")
				
				.getResultList();
		
		
		session1.close();
		for(Object ob : likedbooks) {
			Books b = (Books)ob;
			System.out.println(b);
			
		}
		
		System.out.println();
		// get list of all the users who liked a particular book
		Session session2 = sessionFactory.openSession();
//		List users = session2
//				.createQuery("select distinct b.users from Books b join b.users where b.id=4")
//				.getResultList();
		
		List users = session2
				.createQuery("select b from Users b join b.likedbooks lb where lb.id=4")
				.getResultList();
		
		session2.close();

		for(Object ob : users) {
			Users u = (Users)ob;
			System.out.println(u);
		}
		
		System.out.println();
		// get list of all the data from likedbooks
		Session session3 = sessionFactory.openSession();
		List data = session3.createNativeQuery("select useremail, bookid from likedbooks").getResultList();
		
		session3.close();
		
		Iterator it = data.iterator();
		while(it.hasNext()) {
			Object ob[] = (Object[])it.next();
			System.out.println("Email "+ob[0]+" Book Id "+ob[1]);
		}
		session3.close();

	}


}
