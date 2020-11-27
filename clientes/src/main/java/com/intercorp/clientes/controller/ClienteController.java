package com.intercorp.clientes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intercorp.clientes.model.Cliente;
import com.intercorp.clientes.service.ClienteServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Clientes" })
public class ClienteController {

	private ClienteServiceImpl clienteService;

	public ClienteServiceImpl getClienteService() {
		return clienteService;
	}
	
	@Autowired
	public void setClienteService(ClienteServiceImpl clienteService) {
		this.clienteService = clienteService;
	}
	
	@RequestMapping("/creacliente")
	@PostMapping
	@ApiOperation(value = "Registrar los datos del cliente")
	public void creaCliente(@RequestBody Cliente cli) {
		clienteService.grabarCliente(cli);
	}
	
	@RequestMapping("/kpidecliente")
	@GetMapping
	@ApiOperation(value = "Obtener el promedio y desviacion estandar de la edad de clientes")
	public List<Double> obtenerPromDevEst(){
		List<Cliente> lista = getClienteService().obtenerClientes();
		double promedio = getClienteService().obtenerPromedio(lista);
		double desvEstandar = getClienteService().obtenerDesvEstandar(lista, promedio);
		
		List<Double> estadistica = new ArrayList<>();
		estadistica.add(promedio);
		estadistica.add(desvEstandar);
		return estadistica;
	}
	
	@RequestMapping("/listclientes")
	@GetMapping
	@ApiOperation(value = "Obtener lista de clientes", response = Cliente.class)
	public ResponseEntity<List<Cliente>> obtenerListaClientes(){
		return ResponseEntity.ok(getClienteService().obtenerClientes());
	}
	
	

}
