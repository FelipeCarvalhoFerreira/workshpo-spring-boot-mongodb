package com.felipecarvalho.workshopmongo.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.felipecarvalho.workshopmongo.dominio.PublicarConteudo;


@Repository
public interface PublicarConteudoRepositorio extends MongoRepository<PublicarConteudo, String> {
	
	@Query("{ 'tituloPublicacao': { $regex: ?0, $options: 'i' } }")
	List<PublicarConteudo> encontrarPublicacaoPorTitulo(String texto);
	// busca po parte do nome do titulo ignorando letras maiusculas e minusculas
	
	List<PublicarConteudo> findByTituloPublicacaoContainingIgnoringCase(String texto); 
	/*
	//variavel do tipo String "texto" recebe o parametro digitado pelo usuario na pesquisa
	// metodo do spring data
	//findByTituloPublicacaoContainingIgnoringCase - encontrar por Titulo Publicacao contendo ignorando letras maisculas e minusculas
	*/
	
	@Query("{ $and: [ { dataPublicacao: {$gte: ?1} }, { dataPublicacao: { $lte: ?2} } , { $or: [ { 'tituloPublicacao': { $regex: ?0, $options: 'i' } }, { 'textoPublicacao': { $regex: ?0, $options: 'i' } }, { 'comentarios.texto': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<PublicarConteudo> encontrarPublicacaoPorTudoEntreData(String texto, Date dataInicioPesquisa, Date dataFimPesquisa);
	//Pesquisar por tudo, titulo, conteudo e comentarios.
}




