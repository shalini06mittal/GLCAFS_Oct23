package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BmiCalculatorServlet
 */
@WebServlet("/bmicalc")
public class BmiCalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		
		int age = Integer.parseInt(request.getParameter("age"));
		int height = Integer.parseInt(request.getParameter("height"));
		int weight = Integer.parseInt(request.getParameter("weight"));
		String unit = request.getParameter("unit");
		
		double bmi = 0.0;
		if(unit.equals("kg"))
		{
			bmi = (double)weight/ height*height;
		}
		else{
			bmi = (double)weight/ height*height * 703; 
		}
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		out.println("<h1>Your BMI : </h1>");
		out.println("<p>Age : "+age+"</p>");
		out.println("<p>Height : "+height+"</p>");
		out.println("<p>Weight : "+weight+ " "+unit+ "</p>");
		out.println("<p>BMI : "+bmi+  "</p>");
	}

	

}
