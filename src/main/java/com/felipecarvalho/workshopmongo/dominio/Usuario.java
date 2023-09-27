package com.felipecarvalho.workshopmongo.dominio;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String id;
	private String nomeUsuario;
	private String emailUsuario;
	
	public Usuario(){
	}

	public Usuario(String id, String nomeUsuario, String emailUsuario) {
		this.id = id;
		this.nomeUsuario = nomeUsuario;
		this.emailUsuario = emailUsuario;
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
	
}
