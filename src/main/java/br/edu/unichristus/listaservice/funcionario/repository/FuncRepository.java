package br.edu.unichristus.listaservice.funcionario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unichristus.listaservice.funcionario.data.model.Funcionario;



public interface FuncRepository extends JpaRepository<Funcionario, Long >{
	
	public Optional<Funcionario> findByLogin(String login);
	

}
