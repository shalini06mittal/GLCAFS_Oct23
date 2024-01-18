package com.rd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BmiCalcutor
 */
@WebServlet("/process")
public class BmiProcessRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BmiProcessRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("DO GET BMI PROCESS");
//		
//		String name = request.getParameter("name");
//		PrintWriter out = response.getWriter();
//		//String msg = (String) request.getAttribute("message");
//		//out.println(msg);
//		out.println("Welome "+name.toUpperCase());
		
		int age = (Integer)request.getAttribute("age");
		int height = (Integer)request.getAttribute("height");
		int weight = (Integer)request.getAttribute("weight");
		String unit = request.getParameter("unit");
		
		double bmi = 0.0;
		if(unit.equals("kg"))
		{
			bmi = (double)weight/ height*height;
		}
		else{
			bmi = (double)weight/ height*height * 703; 
		}
		request.setAttribute("bmi", bmi);
		request.setAttribute("status", "Overweight");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
