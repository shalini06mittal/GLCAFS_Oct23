package utility;

import java.util.Iterator;
import java.util.List;

import entity.Blog;

public class PrintFormats {

	public static void displayBlogs(List<Blog> blogs) {
		System.out.println("\n--------------------------------- BLOGS ---------------------------------\n");
		
		if(blogs.size()!=0)
		for(Blog blog: blogs) {
			displayBlog(blog);
		}
		else
			System.out.printf("NO BLOGS YET%n");
			
	}
	public static void displayBlog(Blog blog) {
		System.out.printf("%-15s : %-20s %n","Id",blog.getBlogid());
		System.out.printf("%-15s : %-20s %n","Title",blog.getTitle());
		System.out.printf("%-15s : %-20s %n","Content",blog.getContent());
		System.out.printf("%-15s : %-20s %n","ImageLink",blog.getImagelink());
		System.out.printf("%-15s : %-20s %n","ICategoryd",blog.getCategory().getCategoryname());
		System.out.printf("%-15s : %-20s %n","Created By",blog.getCreatedBy().getEmail());
		System.out.printf("-----------------------------------------------------------------%n");
	}
}

