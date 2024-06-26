package br.edu.unichristus.listaservice.funcionario.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FuncDTO {

	private Long id;
	
	private String nome;
	private String email;
	private String endereco;
	private String login;
	private String password;
}
