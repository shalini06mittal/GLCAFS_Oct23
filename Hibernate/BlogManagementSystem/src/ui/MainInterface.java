package ui;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import database.UserDatabase;
import entity.Bloggers;
import exception.BloggerRegistrationException;
import service.UserService;
import util.HibernateUtil;

public class MainInterface {

	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		UserDatabase userdatabase = new UserDatabase();
		UserService userService = new UserService(userdatabase);

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
				loginBlogger(sc, userService);
				
				boolean isLogin = true;
				while(isLogin) {
					System.out.println("Choose from the below options:-");

					// Category : id, name
					// Blog : id, title, content, createdAt [ use default timestamp of database ],
					// updatedAt : [ use default timestamp of database ], imagelink, category[ FK ]
					// , createdBy[ blogger email ]

					System.out.println("1. View profile\n2. Logout\n3. View Blogs\n4. Edit Blogs\n5. Delete Blog\n6. View Blog By Id");

					// ADVANCE : 6. filter blogs by category: ask the category to the user and display all the blogs in that category
					// display the list of category available

					int dashboard = sc.nextInt();
					switch(dashboard) {
					case 1:
						System.out.println("Display Blogger Profile");
						//  Profile : Display Blogger info
						break;
					case 2:
						//Logout: display a message "Bye, See ya"
						System.out.println("Bye See Ya");
						isLogin = false;
						break;
					case 3: 
						System.out.println("BLOGS!!");
						/**
						 * 1. View Blogs : display all blogs : ADVANCE : limit(pagination)
						 * // if no blogs are there, display a message: NO BLOGS YET
						 */
						break;
					case 4:
						System.out.println("Enter blog id to edit");
						// Display all the ids of the blogs along with the title
						// if no blogs are there, display a message: NO BLOGS CREATED BY YOU
						break;
					case 5:
						System.out.println("Enter blog id to delete");
						// Display all the ids of the blogs along with the title to delete
						// if no blogs are there, display a message: NO BLOGS CREATED BY YOU to DELETE
						break;
					case 6:
						System.out.println("Enter blog id to view the blog details");
						// Display all the ids of the blogs along with the title to delete
						// if no blogs are there, display a message: NO BLOGS CREATED BY YOU to DELETE
						break;
					}
					if(!isLogin)
						break;
				}
			case 3:
				System.out.println("BLOGS!!");
				/**
				 * 1. View Blogs : display all blogs : ADVANCE : limit(pagination)
				 * // if no blogs are there, display a message: NO BLOGS YET
				 */
				break;
			case 4:
				System.out.println("Thanks for visiting!!!");
				System.exit(0);
			}
		}
	}
	
	public static boolean loginBlogger(Scanner sc, UserService userService) {
		
		System.out.println("Please enter email:- ");
		String email = sc.nextLine();

		System.out.println("Please enter password:- ");
		String password = sc.nextLine();
		userService.validateBlogger(email, password);
		return true;
		
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
