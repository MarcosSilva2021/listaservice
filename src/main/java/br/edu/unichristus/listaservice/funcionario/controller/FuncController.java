package br.edu.unichristus.listaservice.funcionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.listaservice.funcionario.data.dto.FuncDTO;
import br.edu.unichristus.listaservice.funcionario.data.dto.FuncLowDTO;
import br.edu.unichristus.listaservice.funcionario.data.model.Funcionario;
import br.edu.unichristus.listaservice.funcionario.service.FuncService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping("/api/v1/funcionario")
public class FuncController {
	
	@Autowired
    private FuncService service;	
	
	@Operation(summary = "Cadastrar funcionario | role: [ADMIN]", 
			tags = "Funcionario", description = "Possibilita "
					+ "cadastrar um funcionario a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Funcionario retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@PostMapping
	public FuncLowDTO save(@RequestBody FuncDTO funcionario) {
		return service.save(funcionario);
	}
	
	@Operation(summary = "Editar funcionario | role: [ADMIN]", 
			tags = "Funcionario", description = "Possibilita "
					+ "Atualizar um funcionario a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Funcionario retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})	
	@PutMapping
	public FuncLowDTO update(@RequestBody FuncDTO func) {
		return service.save(func);
	}
	
	@Operation(summary = "Retornar todos os funcionarios | role: [ADMIN]", 
			tags = "Funcionario", description = "Possibilita "
					+ "Obter uma lista dos funcionarios")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					" Lista de funcionarios retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@GetMapping("/all")
	public List<FuncLowDTO> listAll(){
		return service.listAll();
	}
	
	@Operation(summary = "Excluir um funcionario | role: [ADMIN]", 
			tags = "Funcionario", description = "Possibilita "
					+ "Excluir um funcionario a "
					+ "partir de um identificador(Id) de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Funcionario excluido com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@Operation(summary = "Exibir um funcionario | role: [ADMIN]", 
			tags = "Funcionario", description = "Possibilita "
					+ "Exibir um funcionario a "
					+ "partir dos dados de entrada")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = 
					"Funcionario retornado com suceso"),
			@ApiResponse(responseCode = "400", description = 
			"Limite de caracteres excedido!"),
			@ApiResponse(responseCode = "409", description = 
			"O Login informado já existe!"),
			@ApiResponse(responseCode = "500", description = 
					"Erro interno no servidor."),
	})
	@GetMapping
	public Funcionario findById(@RequestParam(required = true) Long id) {
		return service.findById(id);
	}

}
