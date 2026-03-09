package it.volta.ts.donadonidevin.bean;

public class Persona {
	private String nome;
	private String cognome;
	private Persona next;
	
	
	public Persona(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public Persona getNext() {
		return next;
	}
	
	public void setNext(Persona next) {
		this.next = next;
	}
}
