package com.greatlearning.library.service;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.greatlearning.library.entity.Book;

import util.HibernateUtil;


public class BookServiceImpl implements BookService {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	
	public List<Book> findAll() {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// find all the records from the database table
		List<Book> books = session.createQuery("from Book").list();

		tx.commit();

		session.close();
		return books;
	}

	
	public Book findById(int id) {

		Book book = new Book();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// find record with Id from the database table
		book = session.get(Book.class, id);

		tx.commit();
		session.close();
		return book;
	}

	
	public void save(Book theBook) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(theBook);

		tx.commit();
		session.close();

	}

	public void deleteById(int id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		// get transaction
		Book book = session.get(Book.class, id);

		// delete record
		session.delete(book);

		tx.commit();
		session.close();

	}

	

}