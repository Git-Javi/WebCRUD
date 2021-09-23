package dev.spring.webcrud.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dev.spring.webcrud.dao.GenericDao;
import dev.spring.webcrud.entity.Cliente;
import dev.spring.webcrud.exception.NotFoundCrudException;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	@Qualifier("clienteDao")
	private GenericDao<Cliente, Long> clienteDao;

	@Override
	public ArrayList<Cliente> listClientes() {
		return clienteDao.readAll();
	}

	@Override
	public void createCliente(Cliente unCliente) {
		clienteDao.create(unCliente);
	}

	@Override
	public Cliente readClienteById(Long id) {
		clienteExists(id);
		return clienteDao.readById(id);
	}

	@Override
	public void updateClienteById(Long id, Cliente unCliente) {
		clienteExists(id);
		clienteDao.update(unCliente);
	}

	@Override
	public void deleteClienteById(Long id) {
		clienteExists(id);
		clienteDao.deleteById(id);
	}

	// ----------------------- Utils ----------------------

	private void clienteExists(Long id) {
		if (!clienteDao.existsById(id)) {
			throw new NotFoundCrudException("#No se ha encontrado ese id de cliente!");
		}
	}

}
