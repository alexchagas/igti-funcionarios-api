package com.igti.alex.dto;

import java.io.Serializable;
import java.util.Date;

public class DependenteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer pessoa;
	private String nome;
	private Date nascimento;
	private String sexo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPessoa() {
		return pessoa;
	}

	public void setPessoa(Integer pessoa) {
		this.pessoa = pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
