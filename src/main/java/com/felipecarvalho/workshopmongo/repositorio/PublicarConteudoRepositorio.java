package com.felipecarvalho.workshopmongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipecarvalho.workshopmongo.dominio.PublicarConteudo;

@Repository
public interface PublicarConteudoRepositorio extends MongoRepository<PublicarConteudo, String> {
}


