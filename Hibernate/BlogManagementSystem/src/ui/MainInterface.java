package ui;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import database.BlogDatabase;
import database.UserDatabase;
import entity.Bloggers;
import exception.BloggerLoginException;
import exception.BloggerRegistrationException;
import service.BlogService;
import service.UserService;
import util.HibernateUtil;
import utility.PrintFormats;

public class MainInterface {

	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		UserDatabase userdatabase = new UserDatabase();
		UserService userService = new UserService(userdatabase);
		BlogDatabase blogDatabase = new BlogDatabase();
		BlogService blogService = new BlogService(blogDatabase);


		while(true) {
			System.out.println("\n*******************************************************************************************\n");
			System.out.println("Welcome to BloggerZ!!");
			System.out.println("Choose from the below options:-");
			System.out.println("1. Register\n2. Login\n3. View Blogs\n4. Exit\n");
			System.out.println("\n*******************************************************************************************\n");

			int choice = sc.nextInt();
			sc.nextLine();

			switch(choice) {
			case 1:
				System.out.println("---------------------- Please Register ----------------------");
				try {
					if(registerBlogger(sc, userService)) {
						System.out.println("---------------------- Registration Successful ----------------------");
						loginBlogger(sc, userService, blogService);
					}
				} catch (BloggerRegistrationException e) {
					// TODO Auto-generated catch block
					System.out.println("---------------------- "+e.getMessage()+" ---------------------- ");
				}
				catch(Exception e)
				{
					System.out.println("---------------------- Please contact admin ----------------------");
				}
				break;
			case 2: 
				System.out.println("---------------------- Please Login!! ----------------------");
				loginBlogger(sc, userService, blogService);
			case 3:
				PrintFormats.displayBlogs(blogService.getAllBlogs());

				break;
			case 4:
				System.out.println("Thanks for visiting!!!");
				System.exit(0);
			}
		}
	}

	public static void loginBlogger(Scanner sc, UserService userService, BlogService blogService) {

		System.out.println("Please enter email:- ");
		String email = sc.nextLine();

		System.out.println("Please enter password:- ");
		String password = sc.nextLine();
		try {
			if( userService.validateBlogger(email, password))
			{
				System.out.println("---------------------- LOGIN SUCCESSFUL ----------------------");
				UserInterface userInterface = new UserInterface(userService, blogService);
				userInterface.userDashboard(sc, email);
			} 
		}catch (BloggerLoginException e) {
			// TODO Auto-generated catch block
			System.out.println("---------------------- "+e.getMessage()+" ---------------------- ");
		}

	}
	public static boolean registerBlogger(Scanner sc, UserService userService) throws BloggerRegistrationException
	{
		System.out.println("Please enter email:- ");
		String email = sc.nextLine();

		System.out.println("Please enter firstname:- ");
		String firstname = sc.nextLine();

		System.out.println("Please enter password:- ");
		String password = sc.nextLine();

		System.out.println("Please enter lastname or hit enter key to skip[ OPTIONAL ]:- ");
		String lastname = sc.nextLine();

		System.out.println("Please enter phone or hit enter key to skip[ OPTIONAL ]:- ");
		String phone = sc.nextLine();

		Bloggers blogger = new Bloggers();
		blogger.setEmail(email);
		blogger.setPassword(password);
		blogger.setFirstname(firstname);
		if(!phone.isBlank())
			blogger.setPhone(phone);
		if(!lastname.isBlank())
			blogger.setLastname(lastname);


		return userService.registerBlogger(blogger);

	}

}
