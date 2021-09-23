package dev.spring.webcrud.service;

import java.util.ArrayList;

import dev.spring.webcrud.entity.Cliente;

public interface ClienteService {

	public ArrayList<Cliente> listClientes();
	
	public void createCliente(Cliente unCliente);

	public Cliente readClienteById(Long id);

	public void updateClienteById(Long id,Cliente unCliente);

	public void deleteClienteById(Long id);

}
