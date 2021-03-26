package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.City;
import repository.CityRepository;

@WebServlet(urlPatterns = {"/city", "/delete"})
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CityServlet() {
        super();
    }
    
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    	System.out.println("Post method of NavigationServlet");	
		
		String link = request.getParameter("link");
		String action=request.getParameter("action");
		String page="listOfCities.jsp";
		
	    	String postalCode= request.getParameter("postalCode");
			String name = request.getParameter("name");
			String action = request.getParameter("action");
			
			boolean validation = true;
			City city = new City();
			
			city.setName(name);
			try {
				long postalcode = Long.parseLong(postalCode);
				city.setPostalCode(postalcode);
			}catch(NumberFormatException nfe) {
				request.setAttribute("PostalCodeError:", "Value " + postalCode + " is invalid.");
				validation=false;
			}
			
			if(validation) {				
				switch (action) {
				case "/delete":
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
    }*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Post method of CityServlet");
		
		String postalCode= request.getParameter("postalCode");
		String name = request.getParameter("name");
		String action = request.getParameter("action");
		
		if (action.equals("cancel")) {
			
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
		boolean validation = true;
		City city = new City();
		
		city.setName(name);
		try {
			long postalcode = Long.parseLong(postalCode);
			city.setPostalCode(postalcode);
		}catch(NumberFormatException nfe) {
			request.setAttribute("PostalCodeError:", "Value " + postalCode + " is invalid.");
			validation=false;
		}
		
		if(validation) {
			
			if(action!=null) {
				
				if (request.getParameter("action").equals("add")) {
					
					CityRepository cityRepository = (CityRepository) getServletContext().getAttribute("cityRepository");
					cityRepository.save(city);
					
					request.setAttribute("city", city);
					HttpSession session = request.getSession();
					session.setAttribute("action", request.getParameter("action"));
					
					request.getRequestDispatcher("listOfCities.jsp").forward(request, response);
				}
				
				if (request.getParameter("action").equals("edit")) {
					
					CityRepository cityRepository = (CityRepository) getServletContext().getAttribute("cityRepository");
					List<City> cities = cityRepository.findAll();
					System.out.println(cities);
					
					for(City c:cities) {
						if(c.getPostalCode()==city.getPostalCode()) {
							cityRepository.update(c, city);
						}
				
					}
					request.setAttribute("city", city);
					HttpSession session = request.getSession();
					session.setAttribute("action", request.getParameter("action"));
					
					request.getRequestDispatcher("listOfCities.jsp").forward(request, response);
				}
				
				if (request.getParameter("action").equals("delete")) {
					
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
			
		}else {
			request.setAttribute("message", "Validation error!");
		}
	}

}
