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

	private class Nodo{
		private Regione nodo;
		private Nodo left, right;
	
		public Nodo(Regione newNodo) {
			this.nodo = newNodo;
			this.left = this.right = null;
		}
	}
}