package context;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.City;
import model.User;
import repository.CityRepository;
import repository.UserRepository;


@WebListener
public class StartupContext implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		UserRepository userRepository = new UserRepository();
    	userRepository.save(new User("Ana","Cvetkovic","ana","ana123"));
    	userRepository.save(new User("Ivan","Jovkovic","ivan","ivan123"));
    	
    	CityRepository cityRepository = new CityRepository();
    	cityRepository.save(new City(11000,"Beograd"));
    	cityRepository.save(new City(34000, "Kragujevac"));
    	
    	sce.getServletContext().setAttribute("userRepository", userRepository);
    	sce.getServletContext().setAttribute("cityRepository", cityRepository);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
