package repository;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserRepository implements Repository<User>{
	List<User> users;
	public UserRepository() {
		users = new ArrayList<User>();
	}
	

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public void save(User entity) {
		users.add(entity);
	}

	@Override
	public void update(User entity, User update) {
		entity = update;
	}

	@Override
	public User delete(User entity) {
		int index = users.indexOf(entity);
		User user = users.get(index);
		users.remove(index);
		return user;
	}

	@Override
	public List<User> findAll() {
		return users;
	}

}
