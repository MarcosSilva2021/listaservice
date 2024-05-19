package br.edu.unichristus.listaservice.cliente.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {

	private Long id;
	
	private String name;
	private String email;
	private String login;
	private String password;
}