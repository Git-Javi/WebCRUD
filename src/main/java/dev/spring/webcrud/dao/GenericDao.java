package dev.spring.webcrud.dao;

import java.io.Serializable;
import java.util.ArrayList;

public interface GenericDao<T extends Serializable, PK extends Serializable> {

	public void create(T t);
	public T readById(PK id);
	public void update(T t);
	public void deleteById(PK id);
	public ArrayList<T> readAll();
	public ArrayList<T> readCustomFilter(String query);
	public T updateCustomFilter(String query);
	public boolean existsById(PK id);
	
}


