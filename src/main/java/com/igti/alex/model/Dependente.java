package com.igti.alex.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "DEPENDENTE")
@Entity
public class Dependente extends AbstractUuidEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "PESSOA")
	private Pessoa pessoa;

	@Column(name = "NOME")
	private String nome;

	
	@Column(name = "NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Date nascimento;

	@Column(name = "SEXO")
	private String sexo;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
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
