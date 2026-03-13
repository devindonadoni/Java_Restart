package boundary;

import bean.Ordine;

public class Lista {
	private Nodo head;
	private int size;
	
	public void addToList(Ordine newOrder) {
		Nodo current = head;
		Nodo newNode = new Nodo(newOrder);
		if(head == null) {
			head = newNode;
			size ++;
		}
		else {
			while(current.next != null) {
				current = current.next;
			}
			current.next = newNode;
			size ++;
		}
	}
	
	public Nodo getHead(Lista lista) {
		return lista.head;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public class Nodo{
		private Ordine nodo;
		private Nodo next;
		
		
		public Nodo(Ordine nodo) {
			super();
			this.nodo = nodo;
			this.next = null;
		}
		public Ordine getNodo() {
			return nodo;
		}
		public void setNodo(Ordine nodo) {
			this.nodo = nodo;
		}
		public Nodo getNext() {
			return next;
		}
		public void setNext(Nodo next) {
			this.next = next;
		}
		
	}
}
