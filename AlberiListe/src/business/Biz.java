package business;

import java.util.List;

import bean.Regione;
import boundary.Albero;
import boundary.Albero.Nodo;
import boundary.Lista;
import boundary.Lista.Node;

public class Biz {
	Albero tree = new Albero();
	Lista listHM = new Lista();
	
	public boolean addToTree(List<String> list) {
		tree = new Albero();
		for(String item : list) {
			Regione regione = new Regione(item);
			tree.addToTree(regione);
		}
		return true;
	}
	
	public void printTree() {
		tree.stampaOrdinata(tree);
	}
	
	public void reserchAbitanti(int min, int max) {
		listHM = new Lista();
		 reserchTree(min, max, tree.getRoot(tree));
	}

	public void reserchProvince(String regione) {
		listHM = new Lista();
		reserchTree(regione, tree.getRoot(tree));
	}
	
	public void reserchPrincipale(String citta, String sigla) {
		listHM = new Lista();
		reserchTree(citta, sigla,  tree.getRoot(tree));
	}
	
	private void reserchTree(int min, int max, Nodo corrente) {
	    if (corrente != null) {
	        reserchTree(min, max, corrente.getLeft());

	        if (corrente.getNodo().getAbitanti() >= min && corrente.getNodo().getAbitanti() <= max) {
	        	listHM.addToList(corrente.getNodo());
	        }

	        reserchTree(min, max, corrente.getRight());
	    }
	}
	private void reserchTree(String regione, Nodo corrente) {
		if (corrente != null) {
	        reserchTree(regione, corrente.getLeft());

	        if (corrente.getNodo().getRegione().toLowerCase().equals(regione.toLowerCase())) {
	        	listHM.addToList(corrente.getNodo());
	        }

	        reserchTree(regione, corrente.getRight());
	    }
	}
	
	private void reserchTree(String citta, String sigla,  Nodo corrente) {
		if (corrente != null) {
	        reserchTree(citta,  sigla, corrente.getLeft());

	        if (corrente.getNodo().getNome().toLowerCase().equals(citta.toLowerCase()) && 
	        		corrente.getNodo().getSigla().toLowerCase().equals(sigla.toLowerCase())
	        		) {
	        	listHM.addToList(corrente.getNodo());
	        }else {
	        	for(String item : corrente.getNodo().getProvince()) {
	        		if(item.toLowerCase().equals(citta.toLowerCase()) && corrente.getNodo().getSigla().equals(sigla.toUpperCase()))
	        			listHM.addToList(corrente.getNodo());
	        	}
	        }

	        reserchTree(citta, sigla, corrente.getRight());
	    }
	}
	
	public void printList() {
		Node current = listHM.getHead(listHM);
		
		while(current != null) {
			System.out.println(current.getNodo().toString());
			current = current.getNext();
		}
		
	}
	
	
	public void printListCity() {
		Node current = listHM.getHead(listHM);
		
		while(current != null) {
			System.out.println(current.getNodo().getNome());
			current = current.getNext();
		}
		
	}
	
}
