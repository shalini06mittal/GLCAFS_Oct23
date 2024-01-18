package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(urlPatterns = "/register", 
initParams = @WebInitParam(name = "country", value = "UK"))
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private List<String> countries ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// jdbc code
    	System.out.println("init called");
    	countries = Arrays.asList("India","UK","China","USA");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get called");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<h1>Please Register</h1>");
		out.println("<form actixon='register' method='post'>");
		out.println("<div>\n"
				+ "            <label for=\"username\">Name: </label>\n"
				+ "            <input type=\"text\" id=\"username\" name='username' placeholder=\"Enter name\">\n"
				+ "        </div>\n"
				+ "        <div>\n"
				+ "            <label for=\"password\"> Password : </label>\n"
				+ "                <input type=\"password\" name='pwd'  placeholder=\"Enter password\">\n"
				+ "        </div>\n"
				+ "        <div>\n"
				+ "            <label for=\"email\">Email</label>\n"
				+ "            <input type=\"email\" name='email' placeholder=\"Enter Email\">\n"
				+ "        </div>");
		out.println("<div>Country : <select name='country'>");
		ServletConfig config = getServletConfig();
		String defaultCountry = config.getInitParameter("country"); 
		for(String country: countries) {
			if(country.equals(defaultCountry))
				out.println("<option value='"+country+"' selected>"+country+"</option>");
			else
				out.println("<option value='"+country+"'>"+country+"</option>");
		}
				out.println("</select>"
				+ "        </div>\n"
				+ "        <div>\n"
				+ "            <input type=\"submit\">            \n"
				+ "        </div>");
		out.println("</form>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String country = request.getParameter("country");
		String email = request.getParameter("email");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		//db call
		out.println("<h1>You are registered. Please Login!!</h1>");
		out.println("<p>Name : "+name+"</p>");
		out.println("<p>Email : "+email+"</p>");
		out.println("<p>Country : "+country+"</p>");
		
		
	}

}
