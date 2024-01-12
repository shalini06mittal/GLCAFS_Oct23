package ui;

import java.util.Scanner;

public class BlogInterface {

	public static void main(String[] args) {
		System.out.println("Welcome to BloggerZ!!");
		System.out.println("Choose from the below options:-");
		System.out.println("1. Register\n2. Login\n3. View Blogs");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Please Register");
			// RegisterService : register() : 
			// take blogger inputs to register and save in database
			// Blogger : email[PK], password, phone, firstname, 
			// ADVANCE : lastname [ optional ] , password and confirm password, add validations for length,  &#$%, joinedOn [ Date ]
			// if registration successful, ask the user to login  and same steps as in case 2
			break;
		case 2: 
			System.out.println("Please enter email and password to login");
			// take input for email and password, validate the credentials from the database and display a message
			// LOGIN OR FAILURE
			/**
			 * ADVANCE : FOR FAILURE
			 * allow the user 3 attempts for the password
			 */
			// if success : Display a menu
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
		}
	}

}
