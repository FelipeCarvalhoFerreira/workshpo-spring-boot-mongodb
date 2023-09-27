package com.felipecarvalho.workshopmongo.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.felipecarvalho.workshopmongo.dominio.Usuario;
import com.felipecarvalho.workshopmongo.repositorio.UsuarioRepositorio;
import com.felipecarvalho.workshopmongo.servico.excecao.ExcecaoObjetoNaoEncontrado;

@Service
public class UsuarioServico {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@GetMapping(value = "/usuarios")
	public List<Usuario> listarTodosUsuarios(){
		return usuarioRepositorio.findAll();
 	}
	
	@GetMapping(value = "/{id}")
	public Usuario listarUsuarioId(String id) {
		Optional<Usuario> usuario = usuarioRepositorio.findById(id);
		return usuario.orElseThrow(()-> new ExcecaoObjetoNaoEncontrado("Usuario não Encontrado"));
		
	} 

}
