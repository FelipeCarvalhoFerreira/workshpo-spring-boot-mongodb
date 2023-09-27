package com.felipecarvalho.workshopmongo.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Publicar implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date dataPublicacao;
	private String tituloPublicacao;
	private String textoPublicacao;
	private Usuario autorPublicacao;
	
	public Publicar() {
	}
	
	public Publicar(String id, Date dataPublicacao, String tituloPublicacao, String textoPublicacao, Usuario autorPublicacao) {
		super();
		this.id = id;
		this.dataPublicacao = dataPublicacao;
		this.tituloPublicacao = tituloPublicacao;
		this.textoPublicacao = textoPublicacao;
		this.autorPublicacao = autorPublicacao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getTituloPublicacao() {
		return tituloPublicacao;
	}

	public void setTituloPublicacao(String tituloPublicacao) {
		this.tituloPublicacao = tituloPublicacao;
	}

	public String getTextoPublicacao() {
		return textoPublicacao;
	}

	public void setTextoPublicacao(String textoPublicacao) {
		this.textoPublicacao = textoPublicacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public Usuario getAutorPublicacao() {
		return autorPublicacao;
	}

	public void setAutorPublicacao(Usuario autorPublicacao) {
		this.autorPublicacao = autorPublicacao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicar other = (Publicar) obj;
		return Objects.equals(id, other.id);
	}
}
