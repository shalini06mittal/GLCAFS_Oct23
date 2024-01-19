package com.greatlearning.library.controller;

import java.io.IOException;

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
@WebServlet("/books/edit")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BookServiceImpl bookService = new BookServiceImpl();
		Book theBook = bookService.findById(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("../Bookedit-form.jsp");
		request.setAttribute("Book", theBook);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String category= request.getParameter("category");
		String author = request.getParameter("author");

		Book book = new Book(name, category, author);
		book.setId(id);
	
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		bookServiceImpl.save(book);
		response.sendRedirect("../books/list");
	}

}
