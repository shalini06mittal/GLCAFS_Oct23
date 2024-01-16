package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")// /first is the url mapping
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstServlet() {
		System.out.println("First Servlet constructor");
	}

	/**
	 * GET - not secured, data ia appended in the url hence limitation on the amount of data that can be sent
	 * POST - secured, data is sent as a payload of the request body. 
	 * no limitation on the amount of data
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		System.out.println(request.getMethod());
		System.out.println(request.getContextPath());
		String prodname = request.getParameter("prodname");
		
		// print writer allows to send the response in the form of HTML back to the browser
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		out.println("<h1>From First Servlet - GET</h1>");
		out.println("<p>Product name "+prodname+"</p>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		System.out.println(request.getMethod());
		System.out.println(request.getContextPath());

		String username = request.getParameter("username");
		
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		out.println("<h1>From First Servlet - POST</h1>");
		out.println("<p>Welcome "+username+"</p>");
		
	}

}
