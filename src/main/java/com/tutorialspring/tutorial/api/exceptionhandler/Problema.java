package com.tutorialspring.tutorial.api.exceptionhandler;


import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
public class Problema {
	
	@Setter
	@Getter
	private Integer status;
	
	@Setter
	@Getter
	private LocalDateTime dataHora;
	
	@Setter
	@Getter
	private String titulo;
	
	@Getter
	@Setter
	private List<Campo> campos;
	
	@AllArgsConstructor
	@Data
	public static class Campo {
		private String nome;
		private String mensagem;
	}
}
