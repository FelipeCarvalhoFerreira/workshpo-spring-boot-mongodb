package com.felipecarvalho.workshopmongo.recurso;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipecarvalho.workshopmongo.dominio.Usuario;
import com.felipecarvalho.workshopmongo.dto.UsuarioDTO;
import com.felipecarvalho.workshopmongo.servico.UsuarioServico;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {
	
	@Autowired
	private UsuarioServico usuarioServico;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> listarTodosUsuario() {
		List<Usuario> listarTodosUsuarios = usuarioServico.listarTodosUsuarios();
		List<UsuarioDTO> listarUsuarioDTO = listarTodosUsuarios.stream().map(usuario -> new UsuarioDTO(usuario)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listarUsuarioDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> listarUsuarioId(@PathVariable String id) {
		Usuario listarUsuarioId = usuarioServico.listarUsuarioId(id);
		return ResponseEntity.ok().body(new UsuarioDTO (listarUsuarioId));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserirUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioServico.deUsuarioDTOparaUsuario(usuarioDTO);
		usuario = usuarioServico.inserirUsuario(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
