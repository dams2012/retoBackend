package com.intercorp.clientes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intercorp.clientes.model.Cliente;
import com.intercorp.clientes.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	public ClienteRepository repository;
	
	@Override
	public Cliente grabarCliente(Cliente entity) {
		return repository.save(entity);
	}
	
	@Override
	public List<Cliente> obtenerClientes() {
		List<Cliente> clientes = repository.findAll();
		for (Cliente cli : clientes) {
			System.out.println(cli.getFechaNac());
			cli.calcularFechaMuerte();
		}
		
		return clientes;
	}
	
	@Override
	public Double obtenerPromedio(List<Cliente> clientes) {
		double suma = 0;		
		
		for (Cliente cli : clientes) {
			suma += cli.getEdad();
		}
		
		return suma/clientes.size();
	}
	
	@Override
	public Double obtenerDesvEstandar(List<Cliente> clientes, double promedio) {
		double suma = 0.0;

		for (Cliente c : clientes) {
			suma = Math.pow(c.getEdad() - promedio, 2);
		}

		return Math.sqrt(suma/clientes.size());
	}
	
}
