package boundary;

import bean.Regione;

public class Lista {
	private Node head;
	private int size;
	
	public void addToList(Regione regione) {
		Node current = head;
		if(head == null)
			head = new Node(regione);
		else {
			while(current.next != null)
				current = current.next;
			
			current.next = new Node(regione);
		}
	}
	
	public Node getHead(Lista lista) {
		return lista.head;
	}
	
	public class Node{
		private Regione nodo;
		private Node next;
		
		public Node(Regione newNodo) {
			this.nodo = newNodo;
			this.next = null;
		}

		public Regione getNodo() {
			return nodo;
		}

		public void setNodo(Regione nodo) {
			this.nodo = nodo;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}

	
	
}
