package br.com.stone.desafio;

public class Produto {
	private String nome;
	private int quantidade;
	private float preco;
	private float peso;
	private String unidade;



	public Produto(String nome, int quantidade, float preco, float peso, String unidade) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		this.peso = peso;
		this.unidade = unidade;
	}
	
	
	public float valorTotal() {
		return this.quantidade * this.preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	
	

}
