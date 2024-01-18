package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String otp = request.getParameter("otp");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<p>Welcome "+name+"</p>");
		out.println("<form action=payment?name="+name+" method=post>");
		out.println("<p><input type='hidden' value="+otp+" name='otp'/></p>");
		out.println("<p>Choose payment : <select name='mode'>"
				+ "<option value='CC'>Credit Card</option>"
				+ "<option value='UPI'>UPI</option></select</p>");
		out.println("<p><input type='submit'/></form>");
	}

}
