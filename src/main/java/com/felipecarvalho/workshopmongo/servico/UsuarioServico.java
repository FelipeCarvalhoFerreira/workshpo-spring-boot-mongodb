package com.felipecarvalho.workshopmongo.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.felipecarvalho.workshopmongo.dominio.Usuario;
import com.felipecarvalho.workshopmongo.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@GetMapping(value = "/usuarios")
	public List<Usuario> listarTodosUsuarios(){
		return usuarioRepositorio.findAll();
 	}
	
	

}
