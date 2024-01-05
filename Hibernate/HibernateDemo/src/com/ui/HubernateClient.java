package com.ui;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class HubernateClient {

	public static void main(String[] args) {
		
		// load the xml file and do all the pre-initialization to connect with the database
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Employee e1 = new Employee(3, "Vedant", "Mumbai", "1212121212");
		Employee e2 = new Employee(2, "Ajit", "Mumbai", "6726567576");
		
		Session session = sessionFactory.openSession();
		// DML -> insert , update and delete
		Transaction tx = session.beginTransaction();
		session.save(e1); // insert into emp (city, countryCode, empname, phone, id) values (?, ?, ?, ?, ?) 
		session.save(e2);
		tx.commit();
		session.close();
		
		//Scanner
		// String name = sc.next();
		
		
	}

}
