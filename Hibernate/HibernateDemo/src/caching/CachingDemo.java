package caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import manytomany.Books;

public class CachingDemo {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session sess1 = sf.openSession();
		System.out.println(sess1.get(Books.class, 1));
		System.out.println(sess1.get(Books.class, 1));
		sess1.close();
		
		System.out.println();
		Session sess2 = sf.openSession();
		System.out.println(sess2.get(Books.class, 1));
		sess2.close();

	}

}
