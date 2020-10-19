package br.com.eleicao.model;

public class Candidato {
	
	private Integer id;
	private String nome;
	private String numero;
	
	public Candidato() {
	}
	
	public Candidato(Integer id, String nome, String numero) {
		this.id = id;
		this.nome = nome;
		this.numero = numero;
	}

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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Candidato [id=" + id + ", nome=" + nome + ", numero=" + numero + "]";
	}
	
	
}
