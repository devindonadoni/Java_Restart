package it.volta.ts.donadonidevin.bean;

public class Prodotto {
	private String nome;
	private String codice;
	private float weight;
	private float price;
	private Prodotto next;
	
	public Prodotto(String nome, String codice, float weight, float price) {
		this.nome = nome;
		this.codice = codice;
		this.weight = weight;
		this.price = price;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Prodotto getNext() {
		return next;
	}

	public void setNext(Prodotto next) {
		this.next = next;
	}
	
	
}
