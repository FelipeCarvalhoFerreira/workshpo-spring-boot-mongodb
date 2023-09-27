package com.felipecarvalho.workshopmongo.recurso.excecao;

import java.io.Serializable;

public class ErroPadrao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long dataHora;
	private Integer status;
	private String erro;
	private String mensagem;
	private String camiho;
	
	public ErroPadrao() {
	}

	public ErroPadrao(Long dataHora, Integer status, String erro, String mensagem, String camiho) {
		this.dataHora = dataHora;
		this.status = status;
		this.erro = erro;
		this.mensagem = mensagem;
		this.camiho = camiho;
	}

	public Long getDataHora() {
		return dataHora;
	}

	public void setDataHora(Long dataHora) {
		this.dataHora = dataHora;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCamiho() {
		return camiho;
	}

	public void setCamiho(String camiho) {
		this.camiho = camiho;
	}
	
	

}
