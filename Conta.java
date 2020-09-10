package br.com.senai.model;

import javax.swing.JOptionPane;

public class Conta {
	
	//Atributos
	private Integer codigo;
	private Pessoa 	cliente;
	private Banco 	banco;
	private Double 	saldo;
	private Double 	limite;
	private Boolean ativo;
	
	//Construtores
	public Conta(Integer codigo, Pessoa cliente, Banco banco, Double saldo, Double limite) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.banco = banco;
		this.saldo = saldo;
		this.limite = limite;
		this.ativo = true;
		
	}
	public Conta(Integer codigo, Pessoa cliente, Banco banco) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.banco = banco;
		this.ativo = true;
		this.saldo = 0D;
		this.limite = 0D;
	}
	public Conta() {
		this.ativo = true;
	}
	
	//GETs and SETs
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Pessoa getCliente() {
		return cliente;
	}
	public Banco getBanco() {
		return banco;
	}
	public Double getSaldo() {
		return saldo;
	}
	public Double getLimite() {
		return limite;
	}
	public Boolean getAtivo() {
		return ativo;
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
		Conta other = (Conta) obj;
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
		sb.append("Cliente: "+this.cliente.getNome()+", ");
		sb.append("Banco: "+this.banco.getSigla()+", ");
		sb.append("Saldo: "+this.saldo+", ");
		sb.append("Limite: "+this.limite+", ");
		sb.append("Ativo: "+this.ativo);
		return sb.toString();
	}
	
	public void ativar() {
		this.ativo = true;
		}
	public void desativar( ) {
		this.ativo = false;
	}
	public Boolean saque(Double valor) {
		if (this.saldo >= valor && valor > 0) {
			this.saldo -=valor;
			return true;
		}
		else {
			if (this.saldo < valor && valor > 0) {
				JOptionPane.showMessageDialog(null, "Você não tem Saldo suficiente!");
			}		
			if (valor <0) {
				JOptionPane.showMessageDialog(null, "Só é possível sacar valores positivos!");
			}
			return false;
		}
	}
	public Boolean deposito(Double valor) {
		if (valor > 0) {
		this.saldo += valor;
		return true;
	}else {
		JOptionPane.showMessageDialog(null, "Só é possivel depositar valores positivos!");
		return false;}
	}

}
