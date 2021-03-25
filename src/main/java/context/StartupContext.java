package context;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.City;
import model.User;


@WebListener("Configuration")
public class StartupContext implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<User> users = new ArrayList<>();
		users.add(new User("Ana","Cvetkovic", "ana", "ana123"));
		users.add(new User("Ivan", "Jovkovic", "ivan", "ivan123"));
		sce.getServletContext().setAttribute("users", users);
		
		List<City> cities = new ArrayList<>();
		cities.add(new City(11000,"Beograd"));
		cities.add(new City(34000,"Kragujevac"));
		cities.add(new City(11300,"Smederevo"));
		sce.getServletContext().setAttribute("cities", cities);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
