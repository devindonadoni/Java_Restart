package it.volta.ts.donadonidevin.main;

import java.io.IOException;
import java.util.List;

import it.volta.ts.donadonidevin.business.Business;

public class Classed {

	public Classed() {

	}
	Business business = new Business();

	public void eseguiLista(String filename) {
		List<String> list = new Util().readFile(filename);
		business.Parsing(list);
		print();
		
		business.removeFromList();
		print();
		
		business.removeFromList();
		print();
	}
	
	private void eseguiPila(String filename) {
		List<String> list = new Util().readFile(filename);
		
	}
	
	public void print() {
		System.out.println("-------------------------");
		business.printList(business.getFirst());
		System.out.println("-------------------------");
	}

	public static void main(String[] args) throws IOException {
		if(args.length != 0) {
			new Classed().eseguiPila(args[1]);
		}else 
			System.out.println("file non trovato");
	}
}
