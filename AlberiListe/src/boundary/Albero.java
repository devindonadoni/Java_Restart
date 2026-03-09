package boundary;

import bean.Regione;

public class Albero {
	private Nodo root;
	private int size;
	
	public void addToTree(Regione regione) {
		root = addRic(root, regione);
	}

	private Nodo addRic(Nodo corrente, Regione regione) {

		if (corrente == null) {
			size++;
			return new Nodo(regione);
		}

		if (regione.getNome().compareTo(corrente.nodo.getNome()) < 0) {
			corrente.left = addRic(corrente.left, regione);
		} else {
			corrente.right = addRic(corrente.right, regione);
		}

		return corrente;
	}
	
	
	public Nodo getRoot(Albero albero) {
		return albero.root;
	}

	
	
	//TODO move print into biz 
	public void stampaOrdinata(Albero albero) {
	    stampaInOrder(albero.root);
	}

	
	private void stampaInOrder(Nodo corrente) {
	    if (corrente != null) {
	        stampaInOrder(corrente.left);
	        System.out.println(corrente.nodo.toString()); 
	        stampaInOrder(corrente.right);
	    }
	}

	public class Nodo{
		private Regione nodo;
		private Nodo left, right;
	
		public Nodo(Regione newNodo) {
			this.nodo = newNodo;
			this.left = this.right = null;
		}

		public Regione getNodo() {
			return nodo;
		}

		public void setNodo(Regione nodo) {
			this.nodo = nodo;
		}

		public Nodo getLeft() {
			return left;
		}

		public void setLeft(Nodo left) {
			this.left = left;
		}

		public Nodo getRight() {
			return right;
		}

		public void setRight(Nodo right) {
			this.right = right;
		}
		
	}
}