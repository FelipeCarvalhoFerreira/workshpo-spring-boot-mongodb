package com.felipecarvalho.workshopmongo.dto;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.felipecarvalho.workshopmongo.dominio.Usuario;

public class AutorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nomeAutorPublicacao;
	
	public AutorDTO() {
	}

	public AutorDTO(Usuario usuario) {
		id = usuario.getId();
		nomeAutorPublicacao = usuario.getNomeUsuario();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomeAutorPublicacao() {
		return nomeAutorPublicacao;
	}

	public void setNomeAutorPublicacao(String nomeAutorPublicacao) {
		this.nomeAutorPublicacao = nomeAutorPublicacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
