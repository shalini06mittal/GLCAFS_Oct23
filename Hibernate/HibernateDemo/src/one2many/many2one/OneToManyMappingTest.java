package one2many.many2one;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class OneToManyMappingTest {

	private static SessionFactory sessionFactory ;
	
	public static void main(String[] args) {

//		
//		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//		sessionFactory = configuration.buildSessionFactory();
//
//		Customer c1 = new Customer("c@c.c", Arrays.asList("8987765675","9999999999"), "C C");
//		
//		Account a1 = new Account("A005", 12000, "Savings");
//		
//		a1.setCustomer(c1);
//		
//		
//		List<Account> accounts = new ArrayList<Account>();
//		accounts.add(a1);
//		
//		c1.setAccount(accounts);
//		
////		Session session = sessionFactory.openSession();
////		
////		Transaction tx = session.beginTransaction();
////		session.save(c1);
////		tx.commit();
////		session.close();
//		
////		Session session = sessionFactory.openSession();
////		Account account =  session.get(Account.class, "A001");
////		session.close();
////		System.out.println(account);
////		System.out.println(account.getCustomer().getEmail());
////		System.out.println(account.getCustomer().getFullname());
//		
//		Session session = sessionFactory.openSession();
//		Customer customer =  session.get(Customer.class, "a@a.c");
//		session.close();
//		System.out.println(customer);
//		System.out.println(customer.getPhone());
		
		int n = 4;
		for (int i=1;i<=n;i++)
		{
			for(int j=1;j<=n-i;j++)
			{
				System.out.print(" \t");
			}
			for(int j=1;j<=i;j++)
			{
				System.out.print("*\t");
			}
			System.out.println();
		}
		
	}
	

}
