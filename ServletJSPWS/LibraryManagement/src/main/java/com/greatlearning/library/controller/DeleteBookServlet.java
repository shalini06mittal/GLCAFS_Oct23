package com.greatlearning.library.controller;

import java.io.IOException;
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
@WebServlet("/books/delete")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		BookServiceImpl bookServiceImpl = new BookServiceImpl();
		bookServiceImpl.deleteById(id);
		response.sendRedirect("../books/list");
	
	}

}
