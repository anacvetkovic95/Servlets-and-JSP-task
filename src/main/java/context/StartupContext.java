package context;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.UserDao;
import model.User;
import service.UserService;
import serviceimpl.UserServiceImpl;


@WebListener("Configuration")
public class StartupContext implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<User> users = new ArrayList<>();
		users.add(new User("Admin", "admin", "admin123"));
		users.add(new User("John Smith", "john", "john123"));
		// Servlet Context - one instance per application
		sce.getServletContext().setAttribute("users", users);
		UserService userService = new UserServiceImpl(new UserDao());
		sce.getServletContext().setAttribute("userService", userService);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
