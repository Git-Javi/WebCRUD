package dev.spring.webcrud.dao;

import java.io.Serializable;
import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.spring.webcrud.entity.Cliente;

@Repository
// @Transactional // SI LO PUSIERA EN LA CLASE DECLARARÍA CUALQUIER MÉTODO QUE SE EJECUTE DE LA MISMA COMO TRASACCIONAL
public class ClienteDao<T extends Serializable, PK extends Serializable> implements GenericDao<T, PK> {

	@Autowired
	private SessionFactory sessionFactory;
	
	private final Class<T> CLASE_ENTIDAD;

	@SuppressWarnings("unchecked")
	public ClienteDao(){
		this.CLASE_ENTIDAD = (Class<T>) Cliente.class;
	}
	
	@Transactional // SI LO PUSIERA EN LA CLASE DECLARARÍA CUALQUIER MÉTODO QUE SE EJECUTE DE LA MISMA COMO TRASACCIONAL
	@Override
	public void create(T t) {
		this.sessionFactory.getCurrentSession().save(t);
	}

	@Transactional 
	@Override
	public T readById(PK id) {
		return (T) this.sessionFactory.getCurrentSession().get(CLASE_ENTIDAD, id);
	}

	@Transactional
	@Override
	public void update(T t) {
		this.sessionFactory.getCurrentSession().update(t);
	}
	
	@Transactional
	@Override
	public void deleteById(PK id) {
		T t = this.sessionFactory.getCurrentSession().get(CLASE_ENTIDAD, id);
		this.sessionFactory.getCurrentSession().delete(t);
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<T> readAll() {
		ArrayList<T> listaClientes;
		listaClientes = (ArrayList<T>) this.sessionFactory.getCurrentSession().createQuery("FROM " + CLASE_ENTIDAD.getName()).list();
		return listaClientes;
	}

	@Override
	public ArrayList<T> readCustomFilter(String query) { return null; }

	@Override
	public T updateCustomFilter(String query) { return null; }

	@Transactional
	@Override
	public boolean existsById(PK id) {
		boolean exists = false;
		try {
			if (readById(id) != null) { exists = true;}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return exists;
	}
	
}

