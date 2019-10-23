package projectgreatgame;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GreatGame
 */
@WebServlet("/")
public class GreatGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreatGame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/view/Game.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Integer num = (Integer) session.getAttribute("num");

		Integer guess = Integer.parseInt(request.getParameter("guess"));
		Random rand = new Random();
		
		if(session.getAttribute("num") == null) {
			session.setAttribute("num", rand.nextInt(100));
		}
		System.out.println("guess: " + guess);
		System.out.println("num: " + num);
		
		if( (int)num == (int)guess) {
			session.setAttribute("num", rand.nextInt(100));
			session.setAttribute("responseType", "correct");
		
		} else if(guess > num) {
			session.setAttribute("responseType", "high");
		} else {
			session.setAttribute("responseType", "low");
		} 
		
		doGet(request, response);
	}
}
