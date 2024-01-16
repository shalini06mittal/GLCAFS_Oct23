package ui;

import java.util.List;
import java.util.Scanner;

import dto.BloggersDTO;
import entity.Blog;
import entity.Bloggers;
import entity.Category;
import exception.EntityNotFoundException;
import service.BlogService;
import service.UserService;
import utility.PrintFormats;

public class UserInterface {

	UserService userService;
	BlogService blogService;

	public UserInterface(UserService userService, BlogService blogService) {
		super();
		this.userService = userService;
		this.blogService = blogService;
	}

	public void userDashboard(Scanner sc, String email) {

		boolean isLogin = true;
		int id;
		String title, content, imageLink, category; 
		while(isLogin) {
			System.out.println("\n*******************************************************************************************\n");
			System.out.println("Choose from the below options:-");
			System.out.println("1. View profile\n2. Logout\n3. View All Blogs\n4. View My Blogs\n5. Add Blog");
			System.out.println("\n*******************************************************************************************\n");
			int dashboard = sc.nextInt();
			sc.nextLine();
			switch(dashboard) {
			case 1:

				try {
					BloggersDTO blogger = userService.getProfile(email);
					System.out.printf("-----------------------------------------------------------------------------%n");
					System.out.println("Profile of "+email);
					System.out.println("Firstname : "+blogger.getFirstname());
					System.out.println("Lastname : "+blogger.getLastname());
					System.out.println("Phone "+blogger.getPhone());
					System.out.println("Joined On "+blogger.getJoinedOn());
				} catch (EntityNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				System.out.printf("-----------------------------------------------------------------%n");
				break;
			case 2:
				System.out.println("Bye See Ya");
				isLogin = false;
				break;
			case 3: 
				PrintFormats.displayBlogs(blogService.getAllBlogs());
				break;
			case 4:
				List<Blog> blogs = blogService.getAllBlogsByEmail(email);

				PrintFormats.displayBlogs(blogs);
				if(blogs.size() > 0) {
					System.out.println("\n*******************************************************************************************\n");
					System.out.println("Choose from the below options:-");
					System.out.println("1. Edit Blog\n2.Delete Blog\n3.View Menu");
					System.out.println("\n*******************************************************************************************\n");
					int ch = sc.nextInt();
					sc.nextLine();
					switch(ch) {
					case 1:
						System.out.println("\nChooose id of the blog to edit:-\n");
						id = sc.nextInt();
						sc.nextLine();
						
						
						Bloggers blogger = userService.getBloggerByEmail(email);
						
						System.out.println("Enter title to update");
						title = sc.nextLine();
						System.out.println("Enter content to update");
						content = sc.nextLine();
						
						Blog blog = blogService.getBlogObject(id);
						blog.setBlogid(id);
						blog.setTitle(title);
						blog.setContent(content);
			
						blog.setCreatedBy(blogger);
						Blog updatedBlog = blogService.editBlog(blog);
						System.out.println("---------------------- BLOG UPDATED ----------------------");
						PrintFormats.displayBlog(updatedBlog);
						System.out.printf("-----------------------------------------------------------------%n");
						break;
					case 2:
						System.out.println("\nChooose id of the blog to delete:-\n");
						id = sc.nextInt();
						
						if(blogService.deleteBlog(id))
							System.out.println("---------------------- BLOG DELETED ----------------------");

						break;
					default:
						break;
					}
					break;
				}
				break;
			case 5:
				System.out.println("---------------------- ADD NEW BLOG ----------------------");
				System.out.println("Enter title");
				title = sc.nextLine();
				System.out.println("Enter content");
				content = sc.nextLine();
				System.out.println("Enter image link");
				imageLink = sc.nextLine();
				System.out.println("Enter category");
				category = sc.nextLine();
				Blog blog = new Blog();
				blog.setImagelink(imageLink);
				
				Category ob = new Category();
				ob.setCategoryname(category);
				
				Bloggers blogger  = new Bloggers();
				blogger.setEmail(email);
				
				blog.setCreatedBy(blogger);
				blog.setCategory(ob);
				blog.setTitle(title);
				blog.setContent(content);
				Blog newblog = blogService.addBlog(blog);
				newblog.setCreatedBy(blogger);
				System.out.println("\n---------------------- BLOG ADDED ----------------------\n");
				PrintFormats.displayBlog(newblog);
				
				break;
			default:
				System.out.println("Wrong choice....");
				break;
			}
			if(!isLogin)
				break;
		}
	}

	// ADVANCE : 6. filter blogs by category: ask the category to the user and display all the blogs in that category
	// display the list of category available



}
