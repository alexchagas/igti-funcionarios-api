package com.igti.alex.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FuncionarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String email;
	private Date nascimento;
	private Date iniciocontrato;
	private String ativo;
	private String sexo;
	private Float salario;
	private List<DependenteDTO> dependentes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public List<DependenteDTO> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<DependenteDTO> dependentes) {
		this.dependentes = dependentes;
	}

}
