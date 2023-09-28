package com.felipecarvalho.workshopmongo.recurso;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PublicarConteudo> listarPublicacaoUsuarioId(@PathVariable String id) {
		PublicarConteudo listaPublicacaoUsuario = publicarConteudoServico.listarPublicacaoUsuarioId(id);
		return ResponseEntity.ok().body(listaPublicacaoUsuario);
	}
	
	@RequestMapping(value = "/buscarPorTituloPublicacao", method=RequestMethod.GET)
	public ResponseEntity<List<PublicarConteudo>> encontarPorTituloPublicacao(@RequestParam(value = "texto", defaultValue = "") String texto) {
		texto = URL.decodificarParamentro(texto);
		List<PublicarConteudo> listaPublicacaoBuscarPorTitulo = publicarConteudoServico.findByTituloPublicacaoContainingIgnoringCase(texto);
		return ResponseEntity.ok().body(listaPublicacaoBuscarPorTitulo);
	}
	
	@RequestMapping(value = "/buscarTudo", method=RequestMethod.GET)
	public ResponseEntity<List<PublicarConteudo>> encontrarTodasPublicacaoEntreData(
			@RequestParam(value = "texto", defaultValue = "") String texto,
			@RequestParam(value = "dataInicioPesquisa", defaultValue = "") String dataInicioPesquisa,
			@RequestParam(value = "dataFimPesquisa", defaultValue = "") String dataFimPesquisa) {
		texto = URL.decodificarParamentro(texto);
		Date dataInicio = URL.converterDataParaString(dataInicioPesquisa, new Date(0L));
		Date dataFim = URL.converterDataParaString(dataInicioPesquisa, new Date());
		List<PublicarConteudo> listaPublicacaoBuscarPorTudo = publicarConteudoServico.encontrarTodasPublicacaoEntreData(texto, dataInicio, dataFim);
		return ResponseEntity.ok().body(listaPublicacaoBuscarPorTudo);
	}
}
