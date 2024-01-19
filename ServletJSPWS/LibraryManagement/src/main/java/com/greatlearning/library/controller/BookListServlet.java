package com.greatlearning.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greatlearning.library.entity.Book;
import com.greatlearning.library.service.BookServiceImpl;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/books/list")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookServiceImpl ob = new BookServiceImpl();
		List<Book> theBooks = ob.findAll();
		RequestDispatcher dispatcher = request.getRequestDispatcher("../list-Books.jsp");
		request.setAttribute("Books", theBooks);
		dispatcher.forward(request, response);
	}

	

}