package com.intercorp.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intercorp.clientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
