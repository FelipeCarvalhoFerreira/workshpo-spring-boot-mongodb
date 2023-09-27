package com.felipecarvalho.workshopmongo.recurso;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipecarvalho.workshopmongo.dominio.Usuario;
import com.felipecarvalho.workshopmongo.dto.UsuarioDTO;
import com.felipecarvalho.workshopmongo.servico.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {
	
	@Autowired
	private UsuarioServico usuarioServico;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listarTodosUsuario() {
		List<Usuario> listarTodosUsuarios = usuarioServico.listarTodosUsuarios();
		List<UsuarioDTO> listarUsuarioDTO = listarTodosUsuarios.stream().map(usuario -> new UsuarioDTO(usuario)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listarUsuarioDTO);
		
	}

	public ResponseEntity<Usuario> listarUsuarioId(String id) {
		return null;
	}

	@PostMapping
	public ResponseEntity<Usuario> InserirUsuario() {
		return null;

	}

}
