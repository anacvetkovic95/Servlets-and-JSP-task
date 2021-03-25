package dao;

import java.util.List;

public interface GenericDao<T, K> {
	
	T save(T entity);
	
	T update(T entity);
	
	void delete(K id);
	
	List<T> findAll();
	
	T findById(K id);

}
