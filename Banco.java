package br.com.senai.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Banco {
	
	//Atributos
	private Integer codigo;
	private String nome;
	private String sigla;
	private String cnpj;
	private List<Conta> contas;
	
	//Construtores
	public Banco(Integer codigo, String nome, String sigla, String cnpj) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sigla = sigla;
		this.cnpj = cnpj;
		this.contas = new ArrayList<Conta>();
	}
	public Banco() {
		super();
		this.contas = new ArrayList<Conta>();
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public List<Conta> getContas() {
		return contas;
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
		Banco other = (Banco) obj;
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
		sb.append("Sigla: "+this.sigla+", ");
		sb.append("CNPJ: "+this.cnpj+", ");
		sb.append("Contas: "+this.contas.size());
		return sb.toString();
	}
	
	
	//MÉTODO
	public Boolean adicionarConta(Conta conta) {
		if (conta.getSaldo()>=0 && conta.getAtivo()==true) {
			this.contas.add(conta);
			return true;
		} else {
			if(conta.getSaldo()<0) {
				JOptionPane.showMessageDialog(null, "Conta com saldos negativo não podem ser adicionado!");
			}
			if(!conta.getAtivo()) {
				JOptionPane.showMessageDialog(null, "Contas desativadas não podem ser adicionadas!");
			}
			return false;
		}
	}

	public Boolean removerConta(Conta conta) {
		if (conta.getSaldo()==0 && !conta.getAtivo()) {
			this.contas.remove(conta);
			return true;
		}
		else {
			if (conta.getSaldo()!=0) {
				JOptionPane.showMessageDialog(null, "Para remover a conta ela deve ter saldo igual a zero!");
			}
			if (conta.getAtivo()) {
				JOptionPane.showMessageDialog(null, "Só é possível remover contas desativadas!");
			}
			return false;
		}
	}
	public String listarContas() {
		StringBuffer sb = new StringBuffer();
		sb.append("Lista de Contas\n");
		for (Conta c : contas) {
			sb.append(c+"\n");
		}
		return sb.toString();
	}
	
	public Boolean ativarConta(Conta conta) {
		if (conta.getBanco().equals(this)) {
			conta.ativar();
			return true;}
		else {
			JOptionPane.showMessageDialog(null, "Tem que ser o mesmo banco!");
		return false;
		}
		}
	public Boolean desativarConta(Conta conta) {
		if (conta.getBanco().equals(this) && conta.getSaldo()>=0) {
			conta.desativar();
			return true;}
		else {
			if (!conta.getBanco().equals(this)) {
			JOptionPane.showMessageDialog(null, "Tem que ser o mesmo banco!");}
			if (conta.getSaldo()<0) {
				JOptionPane.showMessageDialog(null, "Saldo tem que ser positivo ou zero!!!");
			}
		return false;
		}
		}
	
	public Boolean transferir(Double valor, Conta origem, Conta destino) {
		if (origem.getAtivo()) {
			JOptionPane.showMessageDialog(null, "Conta Origem desativada");
			return false;
		}
		if (destino.getAtivo()) {
			JOptionPane.showMessageDialog(null, "Conta Destino desativada");
			return false;
			}
		if (valor <= 0) {
			JOptionPane.showMessageDialog(null, "Valor de transferência tem que ser positivo!");
			return false;
		}
		if (origem.saque(valor)) {
			if (destino.deposito(valor)) {
				return true;
			}else {JOptionPane.showMessageDialog(null, "Impossivel depositar na conta destino");
			origem.deposito(valor);
			return false;}
		}else {
			JOptionPane.showMessageDialog(null, "Impossivel sacar da conta origiem!");
			return false;
		}
	}
	
} 
	
