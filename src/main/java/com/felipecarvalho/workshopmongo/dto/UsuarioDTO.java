package com.felipecarvalho.workshopmongo.dto;

import java.io.Serializable;
import java.util.Objects;

import com.felipecarvalho.workshopmongo.dominio.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nomeUsuario;
	private String emailUsuario;
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario usuarioDTO) {
		id = usuarioDTO.getId();
		nomeUsuario = usuarioDTO.getNomeUsuario();
		emailUsuario = usuarioDTO.getEmailUsuario();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
