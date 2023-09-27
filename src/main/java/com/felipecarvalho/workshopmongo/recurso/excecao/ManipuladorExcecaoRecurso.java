package com.felipecarvalho.workshopmongo.recurso.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.felipecarvalho.workshopmongo.servico.excecao.ExcecaoObjetoNaoEncontrado;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManipuladorExcecaoRecurso {

	@ExceptionHandler(ExcecaoObjetoNaoEncontrado.class)
	public ResponseEntity<ErroPadrao> ExcecaoObjetoNaoEncontrado(ExcecaoObjetoNaoEncontrado execao, HttpServletRequest solicitar) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao erroPadrao = new ErroPadrao(System.currentTimeMillis(), status.value(), "Não Encontrado", execao.getMessage(), solicitar.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}
}
