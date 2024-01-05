package com.ui;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class HubernateClient {

	private static SessionFactory sessionFactory ;
	public static void main(String[] args) {
		
		// load the xml file and do all the pre-initialization to connect with the database
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		
		Employee e1 = new Employee(3, "Vedant", "Mumbai", "1212121212");
		Employee e2 = new Employee(2, "Ajit", "Mumbai", "6726567576");
		
		e2.setEname("Ajit Mittal");
		updateEmployee(e2);
		deleteEmployee(e1);
		
	}
	public static void addEmployee(Employee employee)
	{
		Session session = sessionFactory.openSession();
		// DML -> insert , update and delete
		Transaction tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
	}
	public static void deleteEmployee(Employee employee)
	{
		Session session = sessionFactory.openSession();
		// DML -> insert , update and delete
		Transaction tx = session.beginTransaction();
		session.delete(employee);
		tx.commit();
		session.close();
	}
	public static void updateEmployee(Employee employee)
	{
		Session session = sessionFactory.openSession();
		// DML -> insert , update and delete
		Transaction tx = session.beginTransaction();
		session.update(employee);
		tx.commit();
		session.close();
	}

}
