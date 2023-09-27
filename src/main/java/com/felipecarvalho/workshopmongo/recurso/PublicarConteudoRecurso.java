package com.felipecarvalho.workshopmongo.recurso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipecarvalho.workshopmongo.dominio.PublicarConteudo;
import com.felipecarvalho.workshopmongo.servico.PublicarConteudoServico;

@RestController
@RequestMapping(value = "/publicarConteudo")
public class PublicarConteudoRecurso {

	@Autowired
	private PublicarConteudoServico publicarConteudoServico;

	@GetMapping(value = "/{id}")
	public ResponseEntity<PublicarConteudo> listarPublicacaoUsuarioId(@PathVariable String id) {
		PublicarConteudo listaPublicacaoUsuario = publicarConteudoServico.listarPublicacaoUsuarioId(id);
		return ResponseEntity.ok().body(listaPublicacaoUsuario);
	}

	}
