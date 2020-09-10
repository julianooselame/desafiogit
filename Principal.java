package br.com.senai.view;

import br.com.senai.enumered.Genero;
import br.com.senai.model.Banco;
import br.com.senai.model.Conta;
import br.com.senai.model.Pessoa;

public class Principal {
	
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(1,"Rafael",Genero.MASCULINO,"123","Rua do Rafael");
		Banco b1 = new Banco(1, "Banco do BRasil", "BB", "123");
		Conta c1 = new Conta(1, p1, b1);
		Conta c2 = new Conta(1, p1, b1);
	
		//System.out.println(c1);
		c1.deposito(1100D);
		System.out.println(c1);
		
		b1.transferir(50D, c1, c2);
		System.out.println(c2);
		
	
	}

}
