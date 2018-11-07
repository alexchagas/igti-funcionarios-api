package com.igti.alex.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "PESSOA")
@Entity
public class Pessoa extends AbstractUuidEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Date nascimento;

	@Column(name = "INICIOCONTRATO")
	@Temporal(TemporalType.DATE)
	private Date iniciocontrato;

	@Column(name = "ATIVO")
	private String ativo;

	@Column(name = "SEXO")
	private String sexo;

	@Column(name = "SALARIO")
	private Float salario;
	
	@OneToMany
	@JoinColumn(name = "PESSOA")
	private List<Dependente> dependentes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Date getIniciocontrato() {
		return iniciocontrato;
	}

	public void setIniciocontrato(Date iniciocontrato) {
		this.iniciocontrato = iniciocontrato;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

}
