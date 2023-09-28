package com.felipecarvalho.workshopmongo.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipecarvalho.workshopmongo.dominio.PublicarConteudo;
import com.felipecarvalho.workshopmongo.repositorio.PublicarConteudoRepositorio;
import com.felipecarvalho.workshopmongo.servico.excecao.ExcecaoObjetoNaoEncontrado;

@Service
public class PublicarConteudoServico {
	
	@Autowired
	private PublicarConteudoRepositorio publicarConteudoRepositorio;
	
	public PublicarConteudo listarPublicacaoUsuarioId(String id) {
		Optional<PublicarConteudo> listaPublicacaoUsuario = publicarConteudoRepositorio.findById(id);
		return listaPublicacaoUsuario.orElseThrow(()-> new ExcecaoObjetoNaoEncontrado("Usuario não Encontrado"));
	}
	
	public List<PublicarConteudo> findByTituloPublicacaoContainingIgnoringCase(String texto){ 
		return publicarConteudoRepositorio.findByTituloPublicacaoContainingIgnoringCase(texto);
	} 
}

//findByTituloPublicacaoContainingIgnoringCase - encontrar por Titulo Publicacao contendo ignorando letras maisculas e minusculas