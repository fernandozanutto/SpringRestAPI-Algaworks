package com.tutorialspring.tutorial.domain.exception;

public class EntidadeNaoEncontradaException extends NegocioException {
	
	private static final long serialVersionUID = 1l;

	public EntidadeNaoEncontradaException(String message) {
		super(message);
	}

}
