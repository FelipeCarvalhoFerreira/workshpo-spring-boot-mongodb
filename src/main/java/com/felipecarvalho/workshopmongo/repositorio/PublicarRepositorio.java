package com.felipecarvalho.workshopmongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipecarvalho.workshopmongo.dominio.Publicar;

@Repository
public interface PublicarRepositorio extends MongoRepository<Publicar, String> {
}


