package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Cat;
import models.Dog;

/**
 * Servlet implementation class ShowDog
 */
@WebServlet("/animals/dog")
public class ShowDog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ShowDog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("hello this is me from Show dog!");
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("breed"));
		System.out.println(request.getParameter("weight"));
		
		Dog dog = new Dog(request.getParameter("name"), request.getParameter("breed"), Integer.parseInt(request.getParameter("weight")));
		request.setAttribute("dog", dog);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/Dog.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
