package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import repository.UserRepository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserRepository userRepository = (UserRepository) getServletContext().getAttribute("userRepository");
		String errorMessage="";
		
		boolean found = false;
		List<User> users = userRepository.findAll();
		System.out.println(users);
		for (User u : users) {
			if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
				found = true;
				HttpSession session = request.getSession();
				session.setAttribute("currentUser", new User(u.getName(), u.getSurName(), "",""));
				break;
			}
		}
	
		
		if (found) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			errorMessage+="Wrong username or password";
			request.setAttribute("errorMessage", errorMessage);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	
	}

}
