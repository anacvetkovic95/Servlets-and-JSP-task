package repository;

import java.util.List;

public interface Repository<T> {
	void save(T entity);

	void update(T entity,T update);

	T delete(T entity);

	List<T> findAll();

}
