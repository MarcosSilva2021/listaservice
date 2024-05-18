package br.edu.unichristus.listaservice.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.listaservice.cliente.data.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long >{
	
	

}
