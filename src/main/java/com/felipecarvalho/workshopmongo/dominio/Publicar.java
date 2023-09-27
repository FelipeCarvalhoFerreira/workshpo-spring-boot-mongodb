package com.felipecarvalho.workshopmongo.dominio;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class Publicar implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant dataPublicacao;
	private String tituloPublicacao;
	private String textoPublicacao;
	
	public Publicar() {
	}
	
	public Publicar(Long id, Instant dataPublicacao, String tituloPublicacao, String textoPublicacao) {
		super();
		this.id = id;
		this.dataPublicacao = dataPublicacao;
		this.tituloPublicacao = tituloPublicacao;
		this.textoPublicacao = textoPublicacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Instant dataPublicacao) {
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
