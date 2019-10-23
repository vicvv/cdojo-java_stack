package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cat;

/**
 * Servlet implementation class ShowCat
 */
@WebServlet("/animals/cat")
public class ShowCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("hello this is me from Show cat!");
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("breed"));
		System.out.println(request.getParameter("weight"));
		Cat cat = new Cat(request.getParameter("name"), request.getParameter("breed"), Integer.parseInt(request.getParameter("weight")));
		request.setAttribute("cat", cat);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/Cat.jsp");
        view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(request, response);
		//System.out.println("hi");
				
		//RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/Cat.jsp");
		
	}

}
