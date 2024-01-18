package com.rd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BmiCalcutor
 */
@WebServlet("/bmicalc")
public class BmiCalcutor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BmiCalcutor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//bmicalc?name='Shalini'
//		System.out.println("DO GET BMI CALC");
////		String name = request.getParameter("name");
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html");
//		
//		//request.setAttribute("message", "<h1>Result</h1>");
//		
//		out.println("<h1>Result</h1>");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("process");
//		dispatcher.include(request, response);
//		out.println("Hey");
		
		//out.print(request.getParameter("name"));
		
		int age = Integer.parseInt(request.getParameter("age"));
		int height = Integer.parseInt(request.getParameter("height"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		String unit = request.getParameter("unit");
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		out.println("<h1>Your BMI : </h1>");
		out.println("<p>Age : "+age+"</p>");
		out.println("<p>Height : "+height+"</p>");
		out.println("<p>Weight : "+weight+ " "+unit+ "</p>");

		
		request.setAttribute("age", age);
		request.setAttribute("height", height);
		request.setAttribute("weight", weight);
		request.setAttribute("unit", unit);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("process");
		dispatcher.include(request, response);
		
		out.println("<p>BMI : "+request.getAttribute("bmi")+  "</p>");
		out.println("<p>Status : "+request.getAttribute("status")+  "</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
