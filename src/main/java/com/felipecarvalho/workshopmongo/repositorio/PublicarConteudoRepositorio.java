package com.felipecarvalho.workshopmongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.felipecarvalho.workshopmongo.dominio.PublicarConteudo;
import java.util.List;


@Repository
public interface PublicarConteudoRepositorio extends MongoRepository<PublicarConteudo, String> {
	
	@Query("{ 'tituloPublicacao': { $regex: ?0, $options: 'i' } }")
	List<PublicarConteudo> encontrarPublicacaoPorTitulo(String texto);
	// busca po parte do nome do titulo ignorando letras maiusculas e minusculas
	/*
	List<PublicarConteudo> findByTituloPublicacaoContainingIgnoringCase(String texto); 
	//variavel do tipo String "texto" recebe o parametro digitado pelo usuario na pesquisa
	// metodo do spring data
	//findByTituloPublicacaoContainingIgnoringCase - encontrar por Titulo Publicacao contendo ignorando letras maisculas e minusculas
	*/
}




