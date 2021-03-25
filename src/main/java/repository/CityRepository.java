package repository;

import java.util.ArrayList;
import java.util.List;

import model.City;


public class CityRepository implements Repository<City>{
	private List<City> cities;
	public CityRepository() {
		cities = new ArrayList<City>();
	}
	public CityRepository(List<City> cities) {
		super();
		this.cities = cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	@Override
	public void save(City entity) {
		cities.add(entity);
	}

	@Override
	public void update(City entity, City update) {
		entity = update;
	}

	@Override
	public City delete(City entity) {
		int index = cities.indexOf(entity);
		City city = cities.get(index);
		cities.remove(index);
		return city;
		
	}

	@Override
	public List<City> findAll() {
		return cities;
	}

}
