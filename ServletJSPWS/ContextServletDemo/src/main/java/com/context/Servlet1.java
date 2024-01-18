package com.context;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/s1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	
    	super.init();
    	System.out.println("1 "+getServletContext());
    	//getServletContext().setInitParameter("", "");
    	getServletContext().setAttribute("banner", "HOT DEALS AND OFFERS");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(getServletContext());
		getServletContext().setAttribute("msg", "ENJOY");
		ServletContext context = getServletContext();
		String email = context.getInitParameter("admineamil");
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		out.println("<h1>COntact Admin: "+email+"</h1>");
		out.println("<h1>"+getServletContext().getAttribute("banner")+"</h1>");
		out.println("<h1>"+getServletContext().getAttribute("msg")+"</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
