package com.felipecarvalho.workshopmongo.dominio;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class Comentario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String Id;
	private String textoComentario;
	private Instant dataComentario;
	
	public Comentario() {
	}

	public Comentario(String id, String textoComentario, Instant dataComentario) {
		super();
		Id = id;
		this.textoComentario = textoComentario;
		this.dataComentario = dataComentario;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getTextoComentario() {
		return textoComentario;
	}

	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}

	public Instant getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(Instant dataComentario) {
		this.dataComentario = dataComentario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		return Objects.equals(Id, other.Id);
	}
	
	

}
