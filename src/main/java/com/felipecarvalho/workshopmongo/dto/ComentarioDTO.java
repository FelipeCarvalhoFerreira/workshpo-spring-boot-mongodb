package com.felipecarvalho.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;


public class ComentarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String textoComentario;
	private Date dataComentario;
	private AutorDTO autorDTO;
	
	public ComentarioDTO() {
	}

	public ComentarioDTO (String textoComentario, Date dataComentario, AutorDTO autorDTO) {
		super();
		this.textoComentario = textoComentario;
		this.dataComentario = dataComentario;
		this.autorDTO = autorDTO;
	}
	
	public String getTextoComentario() {
		return textoComentario;
	}

	public void setTextoComentario(String textoComentario) {
		this.textoComentario = textoComentario;
	}

	public Date getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(Date dataComentario) {
		this.dataComentario = dataComentario;
	}
	
	public AutorDTO getAutorDTO() {
		return autorDTO;
	}

	public void setAutorDTO(AutorDTO autorDTO) {
		this.autorDTO = autorDTO;
	}
}
