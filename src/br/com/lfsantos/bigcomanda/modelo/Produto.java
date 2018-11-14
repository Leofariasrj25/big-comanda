package br.com.lfsantos.bigcomanda.modelo;

import java.math.BigDecimal;

public class Produto {
	
	private String nome;
	private BigDecimal preco;
	
	public Produto(String nomeP, BigDecimal precoP) {
		if (nomeP == null || precoP == null) {
			throw new NullPointerException("Critico: foram detectados valores invalidos");
		}
		if (nomeP.equals("")) {
			throw new IllegalArgumentException("Erro: o produto deve possuir um nome");
		}
		if (nomeP.length() < 3) {
			throw new IllegalArgumentException("Erro: o produto deve possuir no minimo 3 caracteres");
		}
		
		if (precoP.signum() == 0) {
			throw new IllegalArgumentException("Erro: o produto deve possuir um valor diferente de 0");
		}
		if (precoP.signum() == -1) {
			throw new IllegalArgumentException("Erro: o produto não pode possuir valor negativo");
		}
		
		this.nome = nomeP;
		
		// BigDecimal isn't immutable and doesn't implemment clone
		// in order to not run the risk of having lost bits i'm doing this awful thing.
		this.preco = new BigDecimal(0).add(precoP);
	}
	
	@Override
	public String toString() {
		return '[' + this.nome + ": R$ " + this.preco + ']'; 
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public BigDecimal getPreco() {
		// see constructor for reasoning
		return new BigDecimal(0).add(this.preco);
	}
	
}
