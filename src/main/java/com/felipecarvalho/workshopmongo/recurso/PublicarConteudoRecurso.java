package com.felipecarvalho.workshopmongo.recurso;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipecarvalho.workshopmongo.dominio.PublicarConteudo;
import com.felipecarvalho.workshopmongo.recurso.util.URL;
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
	
	@GetMapping(value = "/buscarPorTituloPublicacao")
	public ResponseEntity<List<PublicarConteudo>> encontarPorTituloPublicacao(@RequestParam(value = "texto", defaultValue = "") String texto) {
		texto = URL.decodificarParamentro(texto);
		List<PublicarConteudo> listaPublicarConteudo = publicarConteudoServico.findByTituloPublicacaoContainingIgnoringCase(texto);
		return ResponseEntity.ok().body(listaPublicarConteudo);
	}
}
