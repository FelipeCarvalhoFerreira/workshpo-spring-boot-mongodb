package com.felipecarvalho.workshopmongo.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@DBRef(lazy = true)
	List<PublicarConteudo> listaPublicacao = new ArrayList<>();
	
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

	public List<PublicarConteudo> getListaPublicacao() {
		return listaPublicacao;
	}

	public void setListaPublicacao(List<PublicarConteudo> listaPublicacao) {
		this.listaPublicacao = listaPublicacao;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}
}
