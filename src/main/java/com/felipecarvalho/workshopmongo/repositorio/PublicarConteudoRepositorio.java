package com.felipecarvalho.workshopmongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipecarvalho.workshopmongo.dominio.PublicarConteudo;
import java.util.List;


@Repository
public interface PublicarConteudoRepositorio extends MongoRepository<PublicarConteudo, String> {
	
	List<PublicarConteudo> findByTituloPublicacaoContainingIgnoringCase(String texto); 
}

//variavel do tipo String "texto" recebe o parametro digitado pelo usuario na pesquisa


