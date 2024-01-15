package service;

import database.UserDatabase;
import entity.Bloggers;
import exception.BloggerRegistrationException;

public class UserService {

	UserDatabase db;

	public UserService(UserDatabase db) {
		super();
		this.db = db;
	}
	/**
	 * 
	 * @param bloggers
	 * @return
	 * @throws BloggerRegistrationException
	 */
	public boolean registerBlogger(Bloggers bloggers) throws BloggerRegistrationException
	{
		if(bloggers.getEmail() == null || bloggers.getEmail().isBlank())
			throw new BloggerRegistrationException("Email cannot be empty");
		if(db.emailExists(bloggers.getEmail()))
			throw new BloggerRegistrationException("Email exists cannot register");
		if(bloggers.getPassword() == null || bloggers.getPassword().isBlank())
			throw new BloggerRegistrationException("Password cannot be empty");
		if(bloggers.getFirstname() == null || bloggers.getFirstname().isBlank())
			throw new BloggerRegistrationException("Firstname cannot be empty");
		return db.insertBlogger(bloggers);
	}
	
	public boolean validateBlogger(String email, String password)
	{
		db.getCredentials(email, password);
		return true;
	}
}
