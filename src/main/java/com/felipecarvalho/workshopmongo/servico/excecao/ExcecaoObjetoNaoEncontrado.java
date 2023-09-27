package com.felipecarvalho.workshopmongo.servico.excecao;


public class ExcecaoObjetoNaoEncontrado extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ExcecaoObjetoNaoEncontrado (String mensagem) {
		super(mensagem);
	}
	

}
