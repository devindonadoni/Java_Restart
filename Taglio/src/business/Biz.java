package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Ordine;
import bean.Pezzo;
import bean.Pezzo.Forma;
import boundary.Lista;
import boundary.Lista.Nodo;

public class Biz {
	Lista autList = new Lista();
    LocalDate localDate = LocalDate.now(); // Create a date object
	
	public void fetchOrders(List<String> list) {
		ArrayList<Pezzo> listaNuova = new ArrayList<Pezzo>();
		
		for(String item : list.subList(1, list.size())) {
			int i = Integer.parseInt((item.split(":"))[2]);
			while(i != 0) {
				Pezzo newPezzo = new Pezzo(item);
				listaNuova.add(newPezzo);
				i --;
			}
		}
		Ordine newOrder = new Ordine(listaNuova, list.get(0).substring(list.get(0).indexOf("-") + 1));
		
		autList.addToList(newOrder);
	}
	
	public void printOrders() {
		Nodo current = autList.getHead(autList);
		
		while(current != null) {
			System.out.println("============================================================");
			System.out.println("SISTEMA DI GESTIONE TAGLIO LASER — Ordine #"+ localDate.getYear() + "-" + current.getNodo().getNumeroOrdine());
			System.out.println("============================================================");
			
			Forma last = null;
			int i = 1;
			for(Pezzo toCheck : current.getNodo().getListaPezzi()) {
				int n = 0;
				for(Pezzo item : current.getNodo().getListaPezzi()) {
					if(toCheck.getForma() == item.getForma() && toCheck.getDimensione() == item.getDimensione()) {
						n ++;
					}
				}
				if(last !=  toCheck.getForma()) {
					double area = calcArea(toCheck.getForma(), toCheck.getDimensione());
					System.out.println("[" + i  + "]		" + toCheck.getForma() + "     dimensione: " + toCheck.getDimensione() + "cm");
					System.out.println("Area singolo pezzo: " + area + "cm^2");
					System.out.println("Area totale: " + area * n + "cm^2");
					System.out.println("Perimetro: " + calcPerimetro(toCheck.getForma(), toCheck.getDimensione()) + "cm");
					System.out.println("Quantita': " + n + "pz");
					i ++;
				}				
				last = toCheck.getForma();
			}
			
			
			
			
			
			current = current.getNext();
		}
	}
	
	public double calcArea(Forma forma, float dimensione) {
		double result = 0;
		switch(forma) {
		case CERCHIO:
			result = Math.PI * (dimensione * dimensione);  
		case QUADRATO:
			result = dimensione * dimensione;
			
		}
		return result;
	}
	
	public double calcPerimetro(Forma forma, float dimensione) {
		double result = 0;
		switch(forma) {
		case CERCHIO:
			result = Math.PI * dimensione * 2;  
		case QUADRATO:
			result = 4 * dimensione;
			
		}
		return result;
	}
	
	
}
