package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.City;
import repository.CityRepository;

@WebServlet(urlPatterns = {"/navigation","/nav"})
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NavigationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		System.out.println("Post method of NavigationServlet");	
		
		String link = request.getParameter("link");
		String action=request.getParameter("action");
		String page="home.jsp";
		
		if(link!=null) {
			switch(link) {
				case "city":
					switch(action) {
					case "add":
						showNewForm(request,response);
						break;
					case "list":
						request.setAttribute("action", "list");
						page="listOfCities.jsp";
						break;
					case "update":
						request.setAttribute("action", "update");
						page="listOfCities.jsp";
						break;
					case "delete":
						deleteCity(request, response);
						break;
					}
					break;
			}
		}else {
			request.setAttribute("message", "Error: Missing link");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("city.jsp");
        dispatcher.forward(request, response);
    }
	
	private void deleteCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String postalCode= request.getParameter("postalCode");
		String name = request.getParameter("name");
		long postalcode=0;
		
		try {
			postalcode = Long.parseLong(postalCode);
		}catch(NumberFormatException nfe) {
			request.setAttribute("PostalCodeError:", "Value " + postalCode + " is invalid.");
		}
		City city = new City();
		city.setPostalCode(postalcode);
		city.setName(name);
 
		CityRepository cityRepository = (CityRepository) getServletContext().getAttribute("cityRepository");
		List<City> cities = cityRepository.findAll();
		System.out.println(cities);
		
		for(City c:cities) {
			if(c.getPostalCode()==city.getPostalCode()) {
				cityRepository.delete(c);
			}
	
		}
		request.setAttribute("city", city);
		HttpSession session = request.getSession();
		session.setAttribute("action", request.getParameter("action"));
 
		request.getRequestDispatcher("listOfCities.jsp").forward(request, response);
    }
	
	

}
