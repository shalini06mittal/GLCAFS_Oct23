package service;

import database.UserDatabase;
import dto.BloggersDTO;
import entity.Bloggers;
import exception.BloggerLoginException;
import exception.BloggerRegistrationException;
import exception.EntityNotFoundException;

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
	
	
	public boolean validateBlogger(String email, String password) throws BloggerLoginException
	{
		String credentials = db.getCredentials(email, password);
		if(credentials == null)
			throw new BloggerLoginException("Email does not exist");
		else
			if(! password.equals(credentials))
				throw new BloggerLoginException("Invalid password");
		return true;
	}
	public BloggersDTO getProfile(String email) throws EntityNotFoundException {
		Bloggers bloggers = db.getBloggerProfile(email);
		if(bloggers == null)
			throw new EntityNotFoundException("Blogger with email "+email+" does not exist");
		BloggersDTO dto = new BloggersDTO();
		dto.setEmail(email);
		dto.setFirstname(bloggers.getFirstname());
		dto.setLastname(bloggers.getLastname());
		dto.setJoinedOn(bloggers.getJoinedOn());
		dto.setPhone(bloggers.getPhone());
		return dto;
	}
	public Bloggers getBloggerByEmail(String email) {
		return db.getBloggerProfile(email);
	}
}
