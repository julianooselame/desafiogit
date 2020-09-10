package br.com.senai.model;

import br.com.senai.enumered.Genero;

public class Pessoa {
	
	//Atributos
	private Integer codigo;
	private String 	nome;
	private Genero genero;
	private String cpf;
	private String endereco;
	
	//Construtores
	public Pessoa(Integer codigo, String nome, Genero genero, String cpf, String endereco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.genero = genero;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public Pessoa(Integer codigo, String nome, String cpf) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
	}
	public Pessoa() {
	}

	//GETs and SETs
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Código: "+this.codigo+", ");
		sb.append("Nome: "+this.nome+", ");
		sb.append("CPF: "+this.cpf+", ");
		sb.append("Gênero: "+this.genero);
		return sb.toString();
	}
	
}
