package com.felipecarvalho.workshopmongo.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipecarvalho.workshopmongo.dominio.Usuario;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, String> {
}


