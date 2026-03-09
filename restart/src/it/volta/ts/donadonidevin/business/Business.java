package it.volta.ts.donadonidevin.business;

import java.util.List;

import it.volta.ts.donadonidevin.bean.Persona;

public class Business {
	Persona first = null;
	
	public Persona getFirst() {
		return this.first;
	}
	
	public void printList(Persona head) {
		Persona current = head;
		while(current.getNext() != null) {
			System.out.println("Nome: " + current.getNome() + " | Cognome: " + current.getCognome());
			current = current.getNext();
		}
	}
	
	public void Parsing(List<String> list) {
		for(String item : list) {
			String[] splitted = item.split("-");
			addToList(splitted[0], splitted[1]);
		}
	}
	
	public void parsing(List<String> list) {
		
	}
	
	public void addToList(String nome, String cognome){
		Persona current = first;
		Persona toAdd = new Persona(nome, cognome);
		if(current == null) {
			first = toAdd;
		}else {
			while(current.getNext() != null) {
				current = current.getNext();
			}
			if(current.getNext() == null) {
				current.setNext(toAdd);
			}
		}
	}
	
	public void removeFromList() {
		Persona current = first;
		if(current == null)
			return;
		else {
			first = current.getNext();
		}
	}
}
