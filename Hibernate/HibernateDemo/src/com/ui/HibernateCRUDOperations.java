package com.ui;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class HibernateCRUDOperations {

	private static SessionFactory sessionFactory ;
	
	/**
	 * openSession[OS] vs getCurrentSession[CS]
	 * 
	 * OS : always creates a new Session object
	 * needs to be explicitly closed
	 * No extra configuration required in the XML file
	 * performance it is slower in a single threaded environment
	 * 
	 * 
	 * in a single threaded environment
	 * CS : create a new session object if it does not exist
	 * need not be closed explicitly as hibernate takes care of it internally
	 * Requires an extra configuration in the XML file : current_session_contet_class
	 * it is faster
	 * returns a Session instance that is bound to a particular context
	 * 
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {

		//load the xml file and do all the pre-initialization to connect with the database
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();

		Employee e1 = new Employee(3, "Vedant", "Mumbai", "1212121212");
		Employee e2 = new Employee(4, "Raju", "Pune", "76767677676");
		Employee e3 = new Employee(5, "Ranjhita", "Pune", "9293892382");

//		addEmployee(e1);
//		addEmployee(e2);
//		addEmployee(e3);
//		e2.setEname("Ajit Mittal");
//		updateEmployee(e2);
//		deleteEmployee(e1);
		
//		Employee ob1 = getEmployeeByIdUsingGet(1);
//		System.out.println("GET "+ob1.getClass().getName());
//		System.out.println(ob1.getEmpid()+" "+ob1.getEname());
//		//System.out.println(getEmployeeByIdUsingGet(10));// returns null if record does not exist with the specified id
//		System.out.println();
//		Employee ob2 = getEmployeeByIdUsingLoad(1);
//		System.out.println("LOAD "+ob2.getClass().getName());
//		//System.out.println(ob2);
//		System.out.println(ob2.getEmpid()+ " "+ob2.getEname());
		
		for(Employee emp :getAllEmployees() )

			System.out.println(emp);
		
		System.out.println();
//		for(Employee emp :getAllEmployeesByCity("Pune") )
//
//			System.out.println(emp);
//		
		System.out.println();
		for(String name :getAllEmployeesName() )

			System.out.println(name);
		
	}
	
	public static List<Employee> getAllEmployees()
	{
		Session session = sessionFactory.openSession();
		// from Employee [ class name ] HQL -> hibernate Query Language
		List<Employee> emps = session.createQuery("from Employee").list();
		session.close();
		return emps;
	}
	

	public static List<Employee> getAllEmployeesByCity(String city)
	{
		Session session = sessionFactory.openSession();
		// from Employee [ class name ] HQL -> hibernate Query Language
		Query query = session.createQuery("from Employee where city=:city");
		query.setParameter("city", city);
		List<Employee> emps = query.list();
		session.close();
		return emps;
	}
	// PROJECTION OF COLUMN
	public static List<String> getAllEmployeesName()
	{
		Session session = sessionFactory.openSession();
		// from Employee [ class name ] HQL -> hibernate Query Language
		Query query = session.createQuery("select e.ename from Employee e ");
		List<String> emps = query.list();
		session.close();
		return emps;
	}
	// select * from employee where id=?
	// get() => immediately hits the database and returns the record
	// hence get returns null if an id does not exist
	// get() => returns an actual object
	// get should be used when you may or may not be sure, if the record exist in the database
	// performance hit
		public  static Employee getEmployeeByIdUsingGet(int id) {
			Session session = sessionFactory.openSession();
			Employee employee = session.get(Employee.class, id);
			session.close();
			return employee;
		}
		// select * from employee where id=?
		// load() => will not  hits the database unless request for any data except the id
		// hence load throws an exception if an id does not exist
		// throws LazyInitializationException when you try to access any other data except id after the session is closed
		// load() returns a proxy object => associating the object with the identifier
		// load should be used when you are  sure, if the record exist in the database
		// better performance hit
		public  static Employee getEmployeeByIdUsingLoad(int id) {
			Session session = sessionFactory.openSession();
			Employee employee = session.load(Employee.class, id);
			System.out.println(employee);
			session.close();
			return employee;
		}
	public static void addEmployee(Employee employee)
	{
		// actually physical connecting with the database
		Session session = sessionFactory.openSession();
		// DML -> insert , update and delete
		// by default the auto commit is set to false
		Transaction tx = session.beginTransaction();
		session.save(employee);// serialization
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
	

	// select * from employee 

}
