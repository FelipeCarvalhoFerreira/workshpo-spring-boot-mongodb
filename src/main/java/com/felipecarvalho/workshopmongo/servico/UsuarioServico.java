package com.felipecarvalho.workshopmongo.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.felipecarvalho.workshopmongo.dominio.Usuario;
import com.felipecarvalho.workshopmongo.dto.UsuarioDTO;
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
	
	
	public Usuario listarUsuarioId(String id) {
		Optional<Usuario> usuario = usuarioRepositorio.findById(id);
		return usuario.orElseThrow(()-> new ExcecaoObjetoNaoEncontrado("Usuario não Encontrado"));
	} 
	
	
	public Usuario inserirUsuario(Usuario usuario) {
		return usuarioRepositorio.insert(usuario);
	}
	
	public Usuario deUsuarioDTOparaUsuario(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getId(), usuarioDTO.getNomeUsuario(), usuarioDTO.getEmailUsuario());
	}
	

	public void deletarUsuario(String id) {
		listarUsuarioId(id);
		usuarioRepositorio.deleteById(id);
	}

}
