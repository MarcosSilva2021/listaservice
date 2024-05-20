package br.edu.unichristus.listaservice.funcionario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.listaservice.cliente.exception.CommonsException;
import br.edu.unichristus.listaservice.funcionario.data.dto.FuncDTO;
import br.edu.unichristus.listaservice.funcionario.data.dto.FuncLowDTO;
import br.edu.unichristus.listaservice.funcionario.data.model.Funcionario;
import br.edu.unichristus.listaservice.funcionario.dozer.DozerConverter;

import br.edu.unichristus.listaservice.funcionario.repository.FuncRepository;



@Service
public class FuncService {
	
	@Autowired
    private FuncRepository repository;
	
	public FuncLowDTO save(FuncDTO funcDTO) {
		var funcModel = DozerConverter.parseObject(funcDTO, Funcionario.class);
		if(funcModel.getNome().length() > 150) {
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unichristus.backend.service.funcionario.badrequest.exception",
					"Limite de caracteres excedido!"
					);
		}
		var userFind = repository.findByLogin(funcModel.getLogin());
		if(!userFind.isEmpty()) {
			throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.funcionario.conflict.exception",
					"O Login informado já existe!"
					);
		}
		
		
		var funcSaved = repository.save(funcModel);
		
		var userLowDTO = DozerConverter.parseObject(funcSaved, FuncLowDTO.class);
		
		return userLowDTO;
	}
	
	public List<FuncLowDTO> listAll(){
		var listFuncLow = repository.findAll();
		var listConverted = DozerConverter.parseListObjects(listFuncLow, FuncLowDTO.class);
		
		return listConverted;
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Funcionario  findById(Long id) {
		var funcionario = repository.findById(id);
		if(funcionario.isEmpty()) {
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unichristus.backend.service.funcionario.notfound.exception",
					"O usuário com a ID informada, não foi encontrado."
					);
		}
		return funcionario.get();
	}

   

}
