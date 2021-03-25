package serviceimpl;

import dao.GenericDao;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {

	private final GenericDao<User, Long> dao;
	
	public UserServiceImpl(GenericDao<User, Long> dao) {
		super();
		this.dao = dao;
	}

	@Override
	public User login(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
