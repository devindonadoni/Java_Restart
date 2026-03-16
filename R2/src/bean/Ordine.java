package bean;

import java.util.ArrayList;
import java.util.HashMap;

public class Ordine {
	private ArrayList<Pezzo> listaPezzi;
	private String numeroOrdine;
	
	public Ordine(ArrayList<Pezzo> listaPezzi, String numeroOrdine) {
		super();
		this.listaPezzi = listaPezzi;
		this.numeroOrdine = numeroOrdine;
	}
	
	
	public ArrayList<Pezzo> getListaPezzi() {
		return listaPezzi;
	}
	public void setListaPezzi(ArrayList<Pezzo> listaPezzi) {
		this.listaPezzi = listaPezzi;
	}
	public String getNumeroOrdine() {
		return numeroOrdine;
	}
	public void setNumeroOrdine(String numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}
	
}
