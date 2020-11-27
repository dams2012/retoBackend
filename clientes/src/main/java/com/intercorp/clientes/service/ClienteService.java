package com.intercorp.clientes.service;

import java.util.List;

import com.intercorp.clientes.model.Cliente;

public interface ClienteService {

	Cliente grabarCliente(Cliente entity);
	List<Cliente> obtenerClientes();
	Double obtenerPromedio(List<Cliente> clientes);
	Double obtenerDesvEstandar(List<Cliente> clientes, double promedio);
	
}
